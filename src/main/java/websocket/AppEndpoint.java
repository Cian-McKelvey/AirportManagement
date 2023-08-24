package websocket;

import javax.websocket.OnOpen;
import javax.websocket.OnMessage;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.json.JSONObject;

import domain.Aircraft;
import static properties.Constants.*;

import java.io.IOException;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

// Making this endpoint /socket as a general thing, if I make multiple endpoints this can change
// Added the encoders and decoders
@ServerEndpoint(value = "/socket", decoders = AircraftDecoder.class, encoders = AircraftEncoder.class)
public class AppEndpoint {

    private Session session;
    private Logger logger;

    // Basic MongoDB Connections
    MongoClient mongoClient = MongoClients.create(databaseLink);
    MongoDatabase db = mongoClient.getDatabase(databaseName);

    // Overall Airport collection, used for testing
    MongoCollection<Document> collection = db.getCollection(airportCollectionName);


    // Creating a codecs provider, automatic being true means the codecs is applied to any class and its properties
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

    MongoDatabase aircraftPojoDatabaseConnection = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
    MongoCollection<Aircraft> aircraftMongoCollection = aircraftPojoDatabaseConnection.getCollection(aircraftCollectionName, Aircraft.class);

    @OnOpen
    public void onOpen(Session session) throws IOException {
        System.out.println("Session Open: " + session.getId());
        try {
            session.getBasicRemote().sendText("Session successfully connected");
            session.getBasicRemote().sendText("Database Connection Active");
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @OnMessage
    public void onMessage(Session session, String messageContent) throws IOException {
        System.out.println("Message Received: " + messageContent);

        try {
            session.getBasicRemote().sendText("Message Received: " + messageContent);
            Aircraft aircraft = jsonToAircraft(messageContent);
            aircraftMongoCollection.insertOne(aircraft);

        } catch (IOException e) {
            logger.error(e);
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        // WebSocket connection closes
        try {
            session.getBasicRemote().sendText("Session ID: " + session.getId() + " has closed");
        } catch (IOException e) {
            logger.error(e);
        }
    }

    @OnError
    public void onError(Throwable throwable) throws IOException {
        throwable.printStackTrace();
    }



    // {"airline":"American Airlines","manufacturer":"Boeing","model":"747","numSeats":416}
    public static Aircraft jsonToAircraft(String aircraftJson) {

        JSONObject jsonObject = new JSONObject(aircraftJson);

        Aircraft aircraft = new Aircraft();
        aircraft.setAirlineOwner(jsonObject.getString("airline"));
        aircraft.setManufacturer(jsonObject.getString("manufacturer"));
        aircraft.setModel(jsonObject.getString("model"));
        aircraft.setNumSeats(jsonObject.getInt("numSeats"));

        return aircraft;
    }

}