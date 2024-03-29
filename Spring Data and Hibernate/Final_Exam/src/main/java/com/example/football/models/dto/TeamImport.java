package com.example.football.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeamImport {

    @Expose
    private String name;
    @Expose
    private String stadiumName;
    @Expose
    private long fanBase;
    @Expose
    private String history;
    @Expose
    private String townName;

    @Size(min = 3)
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 3)
    @NotNull
    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    @Min(1000)
    public long getFanBase() {
        return fanBase;
    }

    public void setFanBase(long fanBase) {
        this.fanBase = fanBase;
    }

    @Size(min = 10)
    @NotNull
    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
