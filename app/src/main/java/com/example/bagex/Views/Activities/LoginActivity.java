package com.example.bagex.Views.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bagex.Views.BulkOperator.BulkOperatorMainActivity;
import com.example.bagex.R;
import com.example.bagex.Services.APIService;
import com.example.bagex.Services.ServiceFactory;
import com.example.bagex.Utils.Constants;
import com.example.bagex.Utils.SharedPrefsData;
import com.example.bagex.Views.Admin.AdminMainActivity;
import com.example.bagex.Views.DeliveryAgent.DeliveryAgentMainActivity;
import com.example.bagex.Views.ModelClass.RequestModelClasses.LoginPageAPIRequestModel;
import com.example.bagex.Views.ModelClass.ResponseModelClasses.LoginPostAPIResponse;
import com.example.bagex.Views.PickupAgent.PickupAgentMainActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText usenameEdt, passwordEdt,emailEdt;
    private TextView registerText, forgotPasswordText;
    private TextInputLayout usernameLyt, passwordLyt,email_lay;
    private Button loginBtn;
    private Context context;
    private Toolbar toolbar;
    private String Role,Auth_token;
    private Subscription mSubscription;
    ImageView imageView;
    int value;
    private AlertDialog alertDialog, alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = getApplicationContext();
        /* intializing and assigning ID's */
        initViews();
        /* Navigation's and using the views */
        setViews();
    }

    private void initViews() {
        imageView = findViewById(R.id.imageView);
        usernameLyt = findViewById(R.id.usernameLyt);
        passwordLyt = findViewById(R.id.passwordLyt);
        usenameEdt = findViewById(R.id.usenameEdt);
        passwordEdt = findViewById(R.id.passwordEdt);
        loginBtn = findViewById(R.id.loginBtn);
        registerText = findViewById(R.id.registerText);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);
        String register = "<b><font color='#8A8A8A'>" + getString(R.string.don_t_have_an_account_register) + " </font>  <b><font color='#52BCA6'>" + getString(R.string.sign_up) + "</font>";
        // String register = getString(R.string.don_t_have_an_account_register) + "<b>" + getString(R.string.register) + "</b> ";
        registerText.setText(Html.fromHtml(register));
    }

    private void setViews() {
        /**
         * @param OnClickListner
         */
        loginBtn.setOnClickListener(this);
        /**
         * @param OnClickListner
         */
        registerText.setOnClickListener(this);
        /**
         * @param OnClickListner
         */
        forgotPasswordText.setOnClickListener(this);


        usenameEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    usernameLyt.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        passwordEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    passwordLyt.setErrorEnabled(false);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:

                /**
                 * Validations for user name and password
                 *
                 * @return
                 */
                if (validations()) {
                    // to start the Progress Dialog
                    showProgressDialog();

                    //API for Login
                    LoiginAPIPOST();
                }

                break;


            case R.id.registerText:
               /* Intent intent = new Intent(this, SignUpActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();*/
                break;

            case R.id.forgotPasswordText:

                /**
                 * custom forgotPasswordDialog for forgot password
                 */
           //     forgotPasswordDialog();
                break;
        }

    }



    /**
     * Validations for user name and password
     *
     * @return
     */
    private boolean validations() {
        if (TextUtils.isEmpty(usenameEdt.getText().toString())) {
            usernameLyt.setError(getString(R.string.err_please_enter_email));
            usernameLyt.requestFocus();
            usernameLyt.setErrorEnabled(true);
            return false;
        } else if (TextUtils.isEmpty(passwordEdt.getText().toString().trim())) {
            passwordLyt.setError(getString(R.string.err_please_enter_password));
            passwordLyt.setErrorEnabled(true);
            passwordLyt.requestFocusFromTouch();
            passwordLyt.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * custom forgotPasswordDialog for forgot password
     */
/*
    public void forgotPasswordDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_forgot_password, null);
        dialogBuilder.setView(dialogView);
        Button button =  dialogView.findViewById(R.id.ok_btn);
        emailEdt =  dialogView.findViewById(R.id.emailEdt);
        email_lay =  dialogView.findViewById(R.id.email_lay);
        alertDialog = dialogBuilder.create();
        */
/**
         * @param OnClickListner
         *//*

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidEmail(emailEdt.getText().toString())) {
                    email_lay.setError(getString(R.string.err_please_enter_valid_email));
                    email_lay.requestFocus();
                    email_lay.setErrorEnabled(true);
                } else {

                    //API to get forgot Password
                  //  forgotPassWord();
                    Toast.makeText(LoginActivity.this, "valid", Toast.LENGTH_SHORT).show();
                }


            }
        });
        emailEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    email_lay.setErrorEnabled(false);
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        alertDialog.show();
    }
*/

    /**
     * email validations
     *
     * @return
     */
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void LoiginAPIPOST() {
        JsonObject object = loginRequestObject();
        APIService service = ServiceFactory.createRetrofitService(this, APIService.class);
        mSubscription = service.postLogin(object)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginPostAPIResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof HttpException) {
                            ((HttpException) e).code();
                            ((HttpException) e).message();
                            ((HttpException) e).response().errorBody();
                            try {
                                ((HttpException) e).response().errorBody().string();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onNext(LoginPostAPIResponse loginResponse) {

                        // to hide the Progress Dialog
                        hideProgressDialog();

                        if (loginResponse.getMessage().equalsIgnoreCase("Successful.")) {
                            Log.d("response", "onNext: "+loginResponse.toString());
                            Role = loginResponse.getData().get(0).getRoles().get(0) ;
                            Auth_token = "Bearer"+" "+loginResponse.getData().get(0).getToken();
                            SharedPrefsData.putString(getApplicationContext(), Constants.Auth_Token, Auth_token, Constants.PREF_NAME);
                            if(Role.equalsIgnoreCase("Admin")){
                                SharedPrefsData.putString(context, Constants.ROLE, Role, Constants.PREF_NAME);
                                Toast.makeText(getApplicationContext(), " " + loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, AdminMainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }else if(Role.equalsIgnoreCase("Delivery Agent")){
                                SharedPrefsData.putString(context, Constants.ROLE, Role, Constants.PREF_NAME);
                                Toast.makeText(getApplicationContext(), " " + loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, DeliveryAgentMainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }else if(Role.equalsIgnoreCase("Pickup Agent")){
                                SharedPrefsData.putString(context, Constants.ROLE, Role, Constants.PREF_NAME);
                                Toast.makeText(getApplicationContext(), " " + loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, PickupAgentMainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }else if(Role.equalsIgnoreCase("Bulk Operator")){
                                SharedPrefsData.putString(context, Constants.ROLE, Role, Constants.PREF_NAME);
                                Toast.makeText(getApplicationContext(), " " + loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, BulkOperatorMainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            } else {
                                SharedPrefsData.putString(context, Constants.ROLE, Role, Constants.PREF_NAME);
                                Toast.makeText(getApplicationContext(), " " + loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }



                        }else {
                            Toast.makeText(getApplicationContext(), " " + "Login Failed", Toast.LENGTH_LONG).show();

                        }

                    }
                });


    }

    /**
     * Json Object of loginRequestObject
     *
     * @return
     */
    private JsonObject loginRequestObject() {
        LoginPageAPIRequestModel apiRequestModel = new LoginPageAPIRequestModel();
        apiRequestModel.setPrincipalid("3c8bc8b4-1da2-4498-b484-45094ef8d590");
        apiRequestModel.setUsername(usenameEdt.getText().toString().trim());
        apiRequestModel.setPassword(passwordEdt.getText().toString().trim());
        return new Gson().toJsonTree(apiRequestModel).getAsJsonObject();
    }


}
