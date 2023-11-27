package com.ck.namunews;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NewsDTO implements Serializable {
    private int rank;
    @SerializedName("title")
    private String title;
    @SerializedName("company")
    private String company;
    @SerializedName("date")
    private String date;
    @SerializedName("url")
    private String url;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}