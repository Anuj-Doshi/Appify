package com.appify.anuj.appify;

public class Anime {
    private String app_name;
    private String ss1;
    private String ss2;
    private String ss3;
    private String apk;
    private String icon;
    private String description;

    public Anime() {
    }

    public Anime(String app_name, String ss1, String apk, String icon,String ss2,String ss3,String description) {
        this.app_name = app_name;
        this.ss1 = ss1;
        this.ss2 = ss2;
        this.description=description;
        this.ss3 = ss3;
        this.apk = apk;
        this.icon = icon;
    }

    public String getApp_name() {
        return app_name;
    }
    public String getDescription() {
        return description;
    }
    public String getSs1() {
        return ss1;
    }
    public String getSs2() {
        return ss2;
    }
    public String getSs3() {
        return ss3;
    }

    public String getApk() {
        return apk;
    }

    public String getIcon() {
        return icon;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public void setSs1(String ss1) {
        this.ss1 = ss1;
    }

    public void setApk(String apk) {
        this.apk = apk;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setSs2(String ss2) {
        this.ss2 = ss2;
    }

    public void setSs3(String ss3) {
        this.ss3 = ss3;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
