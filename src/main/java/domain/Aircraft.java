package domain;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.codecs.pojo.annotations.BsonRepresentation;
import org.bson.types.ObjectId;

public class Aircraft {

    //@BsonId() // Not Sure if needed
    //@BsonProperty("id")
    private ObjectId id;
    //@BsonRepresentation(BsonType.OBJECT_ID) // Not sure if needed

    @BsonProperty("Manufacturer")
    private String manufacturer;

    @BsonProperty("Model")
    private String model;

    @BsonProperty("Airline")
    private String airlineOwner;

    @BsonProperty("Number of Seats")
    private int numSeats;

    public Aircraft() {}

    // Find out how the BSON Unique object ID works and how to add it to newly created objects
    public Aircraft(String manufacturer, String model, String airlineOwner, int numSeats) {

        this.id = new ObjectId();
        //this.id = ObjectId.get(); // another option not sure which is better rn
        this.manufacturer = manufacturer;
        this.model = model;
        this.numSeats = numSeats;
        this.airlineOwner = airlineOwner;
    }

    public ObjectId getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getAirlineOwner() {
        return airlineOwner;
    }

    public void setAirlineOwner(String airlineOwner) {
        this.airlineOwner = airlineOwner;
    }

    @Override
    public String toString() {
        return "[" + this.getId() + "] [Manufacturer:" + this.manufacturer + "] [Model:" + this.model
                + "] [NumSeats:" + this.getNumSeats() + "] [Owner:" + this.getAirlineOwner() + "]";
    }

    public static void main(String[] args) {
        Aircraft example = new Aircraft("Boeing", "747", "Ryan Air", 416);
        System.out.println(example);
    }
}