package MongoDB;

import domain.Aircraft;
import domain.FlightInformation;
import domain.FlightType;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.time.LocalDate;

import static com.mongodb.client.model.Filters.*;

public class SearchFilters {


    /*
        Class that creates special search filters that returns matching data from the mongodb database
    */


    // Filters for aircraft information
    public static Bson AirplaneManufacturerFilter(String manufacturer) {
        return eq("Manufacturer", manufacturer);
    }

    public static Bson AirplaneModelFilter(String model) {
        return eq("Model", model);
    }



    // Filters for flight information
    public static Bson FlightTypeDepartureFilter(String departureCity) {
        return eq("Departure", departureCity);
    }

    public static Bson FlightTypeDestinationFilter(String destinationCity) {
        return eq("Destination", destinationCity);
    }

    public static Bson FlightTypeDurationFilter(int durationMin) {
        return eq("Duration", durationMin);
    }

    public static Bson FlightTypeDelayedFilter(boolean isDelayed) {
        return eq("isDelayed", isDelayed); // isDelayed may be changed later
    }

    public static Bson FlightTypeDateFilter(LocalDate departureDate) {
        return eq("Date", departureDate);
    }

    public static Bson FlightTypeDateFilter(Aircraft aircraft) {
        return eq("Aircraft", aircraft); // Not sure if this will work
    }

    public static Bson FlightTypeDateFilter(FlightType flightType) {
        return eq("FlightType", flightType); // Uses Java Enums, not sure if this will work properly
    }


    // Filters for booking information
    public static Bson BookingNumberFilter(ObjectId bookingNum) { // This is an int atm, will probably be changed to ObjectId soon though
        return eq("Booking Number", bookingNum);
    }

    public static Bson BookingEmailFilter(String email) {
        return eq("Email", email);
    }

    public static Bson BookingFlightInfoFilter(FlightInformation flightInformation) {
        return eq("Flight Info", flightInformation);
    }

    // Could be used to find a full booking
    public static Bson BookingNumberAndEmailFilter(ObjectId bookingNum, String email) { // Might not be used
        return and(eq("Booking Number", bookingNum), eq("Email", email));
    }

}