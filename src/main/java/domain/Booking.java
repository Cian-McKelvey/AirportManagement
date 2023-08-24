package domain;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;


public class Booking {

    @BsonProperty("Booking Number")
    private ObjectId bookingNum;

    @BsonProperty("Flight Info")
    private FlightInformation flightInformation;

    @BsonProperty("Email")
    private String userEmail;

    public Booking() {}

    public Booking(ObjectId bookingNum, FlightInformation flightInformation, String userEmail) {
        this.bookingNum = bookingNum;
        this.flightInformation = flightInformation;
        this.userEmail = userEmail;
    }

    public ObjectId getBookingNum() {
        return bookingNum;
    }

    public void setBookingNum(ObjectId bookingNum) {
        this.bookingNum = bookingNum;
    }

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public void setFlightInformation(FlightInformation flightInformation) {
        this.flightInformation = flightInformation;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}