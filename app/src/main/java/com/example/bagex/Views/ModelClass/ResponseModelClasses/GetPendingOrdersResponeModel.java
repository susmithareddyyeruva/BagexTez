package com.example.bagex.Views.ModelClass.ResponseModelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPendingOrdersResponeModel {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("request")
    @Expose
    private String request;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
    public class Datum {

        @SerializedName("transcId")
        @Expose
        private String transcId;
        @SerializedName("tAirline")
        @Expose
        private String tAirline;
        @SerializedName("tService")
        @Expose
        private String tService;
        @SerializedName("tPupCity")
        @Expose
        private String tPupCity;
        @SerializedName("tName")
        @Expose
        private String tName;
        @SerializedName("tEmail")
        @Expose
        private String tEmail;
        @SerializedName("tPhone")
        @Expose
        private String tPhone;
        @SerializedName("bagsNo")
        @Expose
        private Integer bagsNo;
        @SerializedName("flightNo")
        @Expose
        private String flightNo;
        @SerializedName("destCity")
        @Expose
        private String destCity;
        @SerializedName("flightDate")
        @Expose
        private String flightDate;
        @SerializedName("flightTime")
        @Expose
        private String flightTime;
        @SerializedName("sLocation")
        @Expose
        private String sLocation;
        @SerializedName("spdDate")
        @Expose
        private String spdDate;
        @SerializedName("spdTime")
        @Expose
        private String spdTime;
        @SerializedName("tCharges")
        @Expose
        private String tCharges;
        @SerializedName("tvat")
        @Expose
        private String tvat;
        @SerializedName("doc")
        @Expose
        private String doc;
        @SerializedName("tStatus")
        @Expose
        private String tStatus;
        @SerializedName("tpupdt")
        @Expose
        private String tpupdt;
        @SerializedName("tDevlDT")
        @Expose
        private String tDevlDT;
        @SerializedName("tPayCardNo")
        @Expose
        private String tPayCardNo;
        @SerializedName("rComments")
        @Expose
        private String rComments;
        @SerializedName("pnrNo")
        @Expose
        private String pnrNo;
        @SerializedName("gpsPoints")
        @Expose
        private String gpsPoints;

        public String getTranscId() {
            return transcId;
        }

        public void setTranscId(String transcId) {
            this.transcId = transcId;
        }

        public String getTAirline() {
            return tAirline;
        }

        public void setTAirline(String tAirline) {
            this.tAirline = tAirline;
        }

        public String getTService() {
            return tService;
        }

        public void setTService(String tService) {
            this.tService = tService;
        }

        public String getTPupCity() {
            return tPupCity;
        }

        public void setTPupCity(String tPupCity) {
            this.tPupCity = tPupCity;
        }

        public String getTName() {
            return tName;
        }

        public void setTName(String tName) {
            this.tName = tName;
        }

        public String getTEmail() {
            return tEmail;
        }

        public void setTEmail(String tEmail) {
            this.tEmail = tEmail;
        }

        public String getTPhone() {
            return tPhone;
        }

        public void setTPhone(String tPhone) {
            this.tPhone = tPhone;
        }

        public Integer getBagsNo() {
            return bagsNo;
        }

        public void setBagsNo(Integer bagsNo) {
            this.bagsNo = bagsNo;
        }

        public String getFlightNo() {
            return flightNo;
        }

        public void setFlightNo(String flightNo) {
            this.flightNo = flightNo;
        }

        public String getDestCity() {
            return destCity;
        }

        public void setDestCity(String destCity) {
            this.destCity = destCity;
        }

        public String getFlightDate() {
            return flightDate;
        }

        public void setFlightDate(String flightDate) {
            this.flightDate = flightDate;
        }

        public String getFlightTime() {
            return flightTime;
        }

        public void setFlightTime(String flightTime) {
            this.flightTime = flightTime;
        }

        public String getSLocation() {
            return sLocation;
        }

        public void setSLocation(String sLocation) {
            this.sLocation = sLocation;
        }

        public String getSpdDate() {
            return spdDate;
        }

        public void setSpdDate(String spdDate) {
            this.spdDate = spdDate;
        }

        public String getSpdTime() {
            return spdTime;
        }

        public void setSpdTime(String spdTime) {
            this.spdTime = spdTime;
        }

        public String getTCharges() {
            return tCharges;
        }

        public void setTCharges(String tCharges) {
            this.tCharges = tCharges;
        }

        public String getTvat() {
            return tvat;
        }

        public void setTvat(String tvat) {
            this.tvat = tvat;
        }

        public String getDoc() {
            return doc;
        }

        public void setDoc(String doc) {
            this.doc = doc;
        }

        public String getTStatus() {
            return tStatus;
        }

        public void setTStatus(String tStatus) {
            this.tStatus = tStatus;
        }

        public String getTpupdt() {
            return tpupdt;
        }

        public void setTpupdt(String tpupdt) {
            this.tpupdt = tpupdt;
        }

        public String getTDevlDT() {
            return tDevlDT;
        }

        public void setTDevlDT(String tDevlDT) {
            this.tDevlDT = tDevlDT;
        }

        public String getTPayCardNo() {
            return tPayCardNo;
        }

        public void setTPayCardNo(String tPayCardNo) {
            this.tPayCardNo = tPayCardNo;
        }

        public String getRComments() {
            return rComments;
        }

        public void setRComments(String rComments) {
            this.rComments = rComments;
        }

        public String getPnrNo() {
            return pnrNo;
        }

        public void setPnrNo(String pnrNo) {
            this.pnrNo = pnrNo;
        }

        public String getGpsPoints() {
            return gpsPoints;
        }

        public void setGpsPoints(String gpsPoints) {
            this.gpsPoints = gpsPoints;
        }

    }

}
