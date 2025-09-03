package org.ticketBooking.entities;

import java.util.List;

public class User {
    private String name;
    private String userID;
    private String email;
    private String password;
    private String phone;
    private String address;
    private List<Ticket> tickets;

    public User(String name, String userID, String email, String password, String phone, String address, List<Ticket> tickets) {
        this.name = name;
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.tickets = tickets;
    }
    public User(){

    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }
    public void printTickets(){
        for(Ticket ticket:tickets){
            ticket.getTicketInfo();
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
