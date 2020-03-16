package com.example.bagex.Views.ModelClass.RequestModelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetBookedOrdersRequestModel {
    @SerializedName("statuslist")
    @Expose
    private List<String> statuslist = null;
    @SerializedName("awbno")
    @Expose
    private Integer awbno;
    @SerializedName("agentid")
    @Expose
    private String agentid;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("departuretime")
    @Expose
    private String departuretime;
    @SerializedName("arrivaltime")
    @Expose
    private String arrivaltime;
    @SerializedName("slotdate")
    @Expose
    private Object slotdate;
    @SerializedName("slottime")
    @Expose
    private Object slottime;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("servicetype")
    @Expose
    private String servicetype;

    public List<String> getStatuslist() {
        return statuslist;
    }

    public void setStatuslist(List<String> statuslist) {
        this.statuslist = statuslist;
    }

    public Integer getAwbno() {
        return awbno;
    }

    public void setAwbno(Integer awbno) {
        this.awbno = awbno;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public Object getSlotdate() {
        return slotdate;
    }

    public void setSlotdate(Object slotdate) {
        this.slotdate = slotdate;
    }

    public Object getSlottime() {
        return slottime;
    }

    public void setSlottime(Object slottime) {
        this.slottime = slottime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

}
