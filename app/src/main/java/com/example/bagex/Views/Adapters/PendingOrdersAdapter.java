package com.example.bagex.Views.Adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bagex.R;
import com.example.bagex.Utils.CommonUtil;
import com.example.bagex.Views.ModelClass.ResponseModelClasses.GetPendingOrdersResponeModel;

import java.util.ArrayList;
import java.util.List;

public class PendingOrdersAdapter <T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;
    private List<T> myDataSet;
    private boolean loading;
    View view;
    Context context;
    ArrayList<GetPendingOrdersResponeModel.Datum> mResponseModel;
    private OnCartChangedListener onCartChangedListener;


    public PendingOrdersAdapter(Context context, List<T> myDataSet, RecyclerView recyclerViewCareers) {
        this.context = context;
        this.myDataSet = myDataSet;
        mResponseModel = (ArrayList<GetPendingOrdersResponeModel.Datum>) myDataSet;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_admin_pending, parent, false);
        vh = new TextViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).tservice.setText(CommonUtil.fromHtml("<b><font color=\"#606060\">" + context.getString(R.string.tService) + "</font><b>" +" "+":"+" "+ mResponseModel.get(position).getTService()));
            ((TextViewHolder) holder).tPupcity.setText(CommonUtil.fromHtml("<b><font color=\"#606060\">" + context.getString(R.string.tpupcity) + "</font><b>" +" "+":"+" "+ mResponseModel.get(position).getTPupCity()));
            ((TextViewHolder) holder).flighttime.setText(CommonUtil.fromHtml("<b><font color=\"#606060\">" + context.getString(R.string.flightTime) + "</font><b>" +
                    " "+":"+" "+CommonUtil.formatDateTimeUi(mResponseModel.get(position).getFlightTime())));
            ((TextViewHolder) holder).bags.setText(CommonUtil.fromHtml("<b><font color=\"#606060\">" + context.getString(R.string.bagsNo) + "</font><b>"
                    +" "+":"+" "+ mResponseModel.get(position).getBagsNo()));
            ((TextViewHolder) holder).main_rel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onCartChangedListener.setCartClickListener("MainClick", position);
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return this.myDataSet.size();
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView tservice , tPupcity, flighttime, bags;
        private RelativeLayout main_rel;

        public TextViewHolder(View itemView) {
            super(itemView);
            main_rel =  itemView.findViewById(R.id.main_rel);
            tservice = itemView.findViewById(R.id.tservice);
            tPupcity =  itemView.findViewById(R.id.tPupcity);
            flighttime = (TextView) itemView.findViewById(R.id.flighttime);
            bags = (TextView) itemView.findViewById(R.id.bags);
        }
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        }
    }

    public void setOnCartChangedListener(OnCartChangedListener onCartChangedListener) {
        this.onCartChangedListener = onCartChangedListener;
    }

    public interface OnCartChangedListener {
        void setCartClickListener(String status, int position);
    }

}