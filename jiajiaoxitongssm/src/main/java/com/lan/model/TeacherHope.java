package com.lan.model;

public class TeacherHope {

    private String t_qiwangID;
    private String t_account;
    private String t_name;
    private String t_kemu;
    private String t_class;
    private int t_money;
    private String t_worktime;


    public String getT_account() {
        return t_account;
    }

    public void setT_account(String t_account) {
        this.t_account = t_account;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }



    public String getT_qiwangID() {
        return t_qiwangID;
    }

    public void setT_qiwangID(String t_qiwangID) {
        this.t_qiwangID = t_qiwangID;
    }

    public String getT_kemu() {
        return t_kemu;
    }

    public void setT_kemu(String t_kemu) {
        this.t_kemu = t_kemu;
    }

    public String getT_class() {
        return t_class;
    }

    public void setT_class(String t_class) {
        this.t_class = t_class;
    }

    public int getT_money() {
        return t_money;
    }

    public void setT_money(int t_money) {
        this.t_money = t_money;
    }

    public String getT_worktime() {
        return t_worktime;
    }

    public void setT_worktime(String t_worktime) {
        this.t_worktime = t_worktime;
    }

    @Override
    public String toString() {
        return "TeacherHope{" +
                "t_qiwangID='" + t_qiwangID + '\'' +
                ", t_account='" + t_account + '\'' +
                ", t_name='" + t_name + '\'' +
                ", t_kemu='" + t_kemu + '\'' +
                ", t_class='" + t_class + '\'' +
                ", t_money=" + t_money +
                ", t_worktime='" + t_worktime + '\'' +
                '}';
    }
}
