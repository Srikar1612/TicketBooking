package org.ticketBooking.entities;

import java.util.Date;

public class Ticket {
    private String TicketID;
    private String source;
    private String destination;
    private Date  date;
    private String userID;
    private Train train;
    private int seatNo;
    private int rowNo;
    public Ticket(String TicketID, String source, String destination, Date date, String userID, Train train, int rowNo, int seatNo) {
        this.TicketID = TicketID;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.userID = userID;
        this.train = train;
        this.rowNo = rowNo;
        this.seatNo = seatNo;

    }
    public Ticket() {

    }
    public void getTicketInfo(){
        System.out.println("User ID: " + userID);
        System.out.println("Ticket ID: " + TicketID);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Date: " + date);
        System.out.println("Train ID: "+train.getTrainID());
        System.out.println("Train No: " + train.getTrainNo());
    }
    public String getTicketID() {
        return TicketID;
    }
    public void setTicketID(String TicketID) {
        this.TicketID = TicketID;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public Train getTrain() {
        return train;
    }
    public void setTrain(Train train) {
        this.train = train;
    }
    public int getSeatNo() {
        return seatNo;
    }
    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
    public int getRowNo() {
        return rowNo;
    }
    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }
}
