package com.beshoy.development.data.model.response.fixtures;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fixture {

    @SerializedName("league_image")
    @Expose
    private String leagueImage;
    @SerializedName("league_name")
    @Expose
    private String leagueName;
    @SerializedName("coins")
    @Expose
    private Integer coins;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("on_air")
    @Expose
    private String onAir;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("team1_img")
    @Expose
    private String team1Img;
    @SerializedName("team1_name")
    @Expose
    private String team1Name;
    @SerializedName("team2_img")
    @Expose
    private String team2Img;
    @SerializedName("team2_name")
    @Expose
    private String team2Name;
    @SerializedName("viewType")
    @Expose
    private int viewType;

    public String getLeagueImage() {
        return leagueImage;
    }

    public void setLeagueImage(String leagueImage) {
        this.leagueImage = leagueImage;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOnAir() {
        return onAir;
    }

    public void setOnAir(String onAir) {
        this.onAir = onAir;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTeam1Img() {
        return team1Img;
    }

    public void setTeam1Img(String team1Img) {
        this.team1Img = team1Img;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Img() {
        return team2Img;
    }

    public void setTeam2Img(String team2Img) {
        this.team2Img = team2Img;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

}
