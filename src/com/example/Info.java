package com.example;

import java.util.Date;

/**
 * @author Xiamuzi
 * @version 1.0
 * @date 2020/5/1 21:44
 */
public class Info {
    private int id;
    private int userid;
    private int heartreat;
    private float oxygen;
    private int pressurehigh;
    private int pressuredown;
    private float temperature;
    private int ecg;
    private Date time;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public int getHeartreat() {
        return heartreat;
    }
    public void setHeartreat(int heartreat) {
        this.heartreat = heartreat;
    }
    public float getOxygen() {
        return oxygen;
    }
    public void setOxygen(float oxygen) {
        this.oxygen = oxygen;
    }
    public int getPressurehigh() {
        return pressurehigh;
    }
    public void setPressurehigh(int pressurehigh) {
        this.pressurehigh = pressurehigh;
    }
    public int getPressuredown() {
        return pressuredown;
    }
    public void setPressuredown(int pressuredown) {
        this.pressuredown = pressuredown;
    }
    public float getTemperature() {
        return temperature;
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
    public int getEcg() {
        return ecg;
    }
    public void setEcg(int ecg) {
        this.ecg = ecg;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", userid=" + userid +
                ", heartreat=" + heartreat +
                ", oxygen=" + oxygen +
                ", pressurehigh=" + pressurehigh +
                ", pressuredown=" + pressuredown +
                ", temperature=" + temperature +
                ", ecg=" + ecg +
                ", time=" + time +
                '}';
    }
}
