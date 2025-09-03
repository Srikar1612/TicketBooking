package org.ticketBooking.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainID;
    private String trainName;
    private String trainNo;
    private List<String> stations;
    private Map<String,String> stationTimes;
    private List<List<Boolean>> seats;
    @JsonProperty("Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM dd yyyy")
    private Date date;
    public Train(String trainID, String trainName, String trainNo, List<String> stations, Map<String,String> stationTimes, Date date) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainNo = trainNo;
        this.stations = stations;
        this.stationTimes = stationTimes;
        this.date = date;
    }
    public Train(){}
    public String getTrainID() {
        return trainID;
    }
    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }
    public String getTrainName() {
        return trainName;
    }
    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }
    public String getTrainNo() {
        return trainNo;
    }
    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }
    public List<String> getStations() {
        return stations;
    }
    public void setStations(List<String> stations) {
        this.stations = stations;
    }
    public Map<String, String> getStationTimes() {
        return stationTimes;
    }
    public void setStationTimes(Map<String, String> stationTimes) {
        this.stationTimes = stationTimes;
    }
    public List<List<Boolean>> getSeats() {
        return seats;
    }
    public void setSeats(List<List<Boolean>> seats) {
        this.seats = seats;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void getTrainInfo() {
        System.out.println("Train ID: " + trainID);
        System.out.println("Train Name: " + trainName);
        System.out.println("Train No: " + trainNo);

    }
}
