package org.ticketBooking.services;

import org.ticketBooking.entities.Ticket;
import org.ticketBooking.entities.Train;
import org.ticketBooking.entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticketBooking.util.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserBookingService {
    private boolean loginSuccess=false;
    private User user;
    private final ObjectMapper mapper = new ObjectMapper();
    public final String userFilePath="app\\src\\main\\java\\org\\ticketBooking\\DataBase\\Users.json";
    private List<User> userList;
    Hash hash=new Hash();
    public UserBookingService(User user) throws IOException {
        this.user = user;
        loadUsersFromJson();
    }
    public UserBookingService() throws IOException {
        loadUsersFromJson();
    }
    public boolean LoginSuccess() {
        return loginSuccess;
    }
    public void loadUsersFromJson() throws IOException{
        userList=mapper.readValue(new File(userFilePath), new TypeReference<>() {
        });
    }
    public void signUp(User user) {
        userList.add(user);
        try {
            mapper.writeValue(new File(userFilePath), userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean login(String email, String password) {
        Optional<User> foundUser= userList.stream().filter(user1 -> user1.getEmail().equalsIgnoreCase(email) && hash.checkPassword(password, user1.getPassword())).findFirst();
        if(foundUser.isPresent()){
            loginSuccess=true;
            this.user = foundUser.get();
            return true;
        }
        return false;
    }
    public void fetchBooking() {
        try {
            Optional<User> user1 = userList.stream().filter(user2 -> user2.getUserID().equalsIgnoreCase(user.getUserID()) && user2.getPassword().equals(user.getPassword())).findFirst();
            user1.ifPresent(User::printTickets);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean cancelBooking(String ticketID) throws IOException {
        if(ticketID==null || ticketID.isEmpty()) {
            System.out.println("Ticket ID can't be empty");
            return false;
        }
        List<Ticket> tickets=user.getTickets();
        if(tickets==null || tickets.isEmpty()) return false;
        Optional<Ticket>found=tickets.stream().filter(ticket -> ticket.getTicketID().equals(ticketID)).findFirst();
        if(found.isPresent()) {
            Optional<Train> train1= Optional.ofNullable(found.get().getTrain());
            if(train1.isPresent()) {
                List<List<Boolean>> seats=train1.get().getSeats();
                int row=found.get().getRowNo();
                int seatNo=found.get().getSeatNo();
                seats.get(row).set(seatNo,false);
                train1.get().setSeats(seats);
                TrainServices ts=new TrainServices();
                ts.updateTrain(train1.get());
            }
            tickets.remove(found.get());
            user.setTickets(tickets);
            int index=userList.indexOf(user);
            userList.set(index,user);
            mapper.writeValue(new File(userFilePath), userList);
            System.out.println("Ticket has been cancelled");
            return true;
        }
        else  {
            System.out.println("Ticket with TicketID: "+ticketID+" not found");
        }
        return false;
    }
    public List<Train> getTrains(String source, String destination) throws IOException {
        TrainServices trainServices=new TrainServices();
        return trainServices.searchTrains(source, destination);
    }
    public List<List<Boolean>> fetchSeats(Train train) throws IOException {
        return train.getSeats();
    }
    public Boolean bookSeat(Train train, String source, String destination, int row, int seat)  throws IOException {
        List<List<Boolean>> seats = fetchSeats(train);
        if(row>=0 && seat>=0 && seat<=seats.size() && seat<=seats.get(row).size()) {
            if(!seats.get(row).get(seat)){
                String TicketID=UUID.randomUUID().toString();
                Date date = train.getDate();
                String UserID=user.getUserID();
                Ticket ticket=new Ticket(TicketID,source,destination,date,UserID,train, row, seat);
                user.addTicket(ticket);
                seats.get(row).set(seat, true);
                TrainServices trainServices=new TrainServices();
                train.setSeats(seats);
                trainServices.updateTrain(train);
                List<Ticket> ticketList=user.getTickets();
                ticketList.add(ticket);
                user.setTickets(ticketList);
                int index=userList.indexOf(user);
                userList.set(index, user);
                mapper.writeValue(new File(userFilePath), userList);
                return true;
            }
            else {
                return false;
            }

        }
        else {
            return false;
        }
    }
}
