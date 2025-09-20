# 🎟️ Ticket Booking System

A **Java-based Ticket Booking System** built with **Gradle**.  
This project manages trains, users, and ticket bookings using **JSON files** for storage.  

---

## 🚀 Features
- Add and manage users.
- Book and cancel tickets.
- View train availability.
- Data stored in simple **JSON files** (`Users.json`, `Trains.json`).

---

## 🛠️ Tech Stack
- **Language**: Java 17+  
- **Build Tool**: Gradle  
- **Storage**: JSON files (Trains & Users)  
- **IDE**: IntelliJ IDEA (recommended)  

---

## 📂 Project Structure
app/ 
├── src/main/java/org/ticketBooking/ │
                            ├── App.java                 # Entry point │
                            ├── DataBase/ │
                            │    ├── Trains.json         # Train data │
                            │    └── Users.json          # User data │
                            ├── entities/                # Models │
                            │    ├── Ticket.java │
                            │    ├── Train.java │
                            │    └── User.java │
                            ├── services/                # Business logic │
                            │    ├── TrainServices.java │
                            │    └── UserBookingService.java │
                            └── util/
                            │    └── Hash.java           # Utility for hashing (passwords, etc.)
                            └── src/test/java/org/example/
                                 └── AppTest.java             # Sample test

---

## ⚡ Getting Started

### Prerequisites
- [Java 17+](https://adoptium.net/)  
- [Gradle](https://gradle.org/install/)  

### Build & Run
```bash
# Clone repository
git clone https://github.com/Srikar1612/TicketBooking.git
cd TicketBooking-master

# Build project
gradle build

# Run project
gradle run
```
Or directly run with Java:
```bash
cd app/src/main/java
javac org/ticketBooking/App.java
java org.ticketBooking.App
```

---

## 💾 Data Storage (JSON Files)
***Users*** are stored in:
```bash
app/data/users.json
```
***Trains*** are stored in:
```bash
app/data/trains.json
```
Example *users.json*:
```bash
[
  {
    "name": "Srikar",
    "userID": "e60d7dab-2529-41a7-8ec7-d5a38db13f0a",
    "email": "sri@gmail.com",
    "password": "$2b$12$fgGZCFVlH83JLFvi1.lOuOLSp3TExFdDX0C7.JuuhyC.fTzrBNi7S",
    "phone": "1234567890",
    "address": "15/5/5",
    "tickets": [
      {
        "source": "New York",
        "destination": "Washington DC",
        "date": 1765843200000,
        "train": {
          "trainID": "TR1001",
          "trainName": "Express Line",
          "trainNo": "12345",
          "stations": ["New York","Philadelphia","Baltimore","Washington DC","Chicago","Los Angeles"],
          "stationTimes": {
            "New York": "08:00",
            "Philadelphia": "09:30",
            "Baltimore": "11:00",
            "Washington DC": "12:30",
            "Chicago": "1:00",
            "Los Angeles": "1:30"
          },
          "seats": [
            [true,true,true,true],
            [true,true,true,true],
            [true,true,true,false],
            [true,true,false,true]
          ],
          "Date": "Dec 16 2025"
        },
        "seatNo": 0,
        "rowNo": 3,
        "ticketID": "a50ae37a-667a-4fff-b8b0-63f18160ce62"
      }
    ]
  }
]
```
**Users** contain personal info + tickets they booked.

**Tickets** reference a train, seat, and journey details.

**Trains** define stations, timings, and seat maps.

---

## ▶️ Example Console Interaction

When running the app, a menu like this may appear:

```bash
--- Ticket Booking System ---
1. View available trains
2. Book a ticket
3. Cancel a ticket
4. View my tickets
5. Exit
Enter your choice:
```

***View available trains*** → Shows trains from Trains.json.

***Book a ticket*** → Prompts for user info, source, destination, train, and seat.

***Cancel a ticket*** → Removes booking from both train and user data.

***View my tickets*** → Lists tickets from Users.json.

---

## 📈 Future Improvements

Database support (MySQL/PostgreSQL) instead of JSON.

REST API endpoints for external integration.

Authentication & roles (Admin/User).

Frontend (Web/Android).

Handle concurrent bookings (thread safety).

---

## 🤝 Contributing

Contributions are welcome!
Fork the repository, create a feature branch, and submit a pull request.

---

## 📜 License

Licensed under the GPL-3.0 License.
See the [LICENSE](LICENSE) file for details.

---
