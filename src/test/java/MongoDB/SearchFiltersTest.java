package MongoDB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import domain.Aircraft;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static properties.Constants.*;

import static com.mongodb.client.model.Filters.eq;

public class SearchFiltersTest {

    // Basic MongoDB Connections - Commented out to reduce mvn clean verify weirdness until implemented
    /*
    MongoClient mongoClient = MongoClients.create(databaseLink);

    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

    MongoDatabase aircraftPojoDatabaseConnection = mongoClient.getDatabase(databaseName)
            .withCodecRegistry(pojoCodecRegistry);

    MongoCollection<Aircraft> aircraftMongoCollection = aircraftPojoDatabaseConnection
            .getCollection(aircraftCollectionName, Aircraft.class);
     */


    @Test
    @DisplayName("Testing Aircraft Manufacturer Filter when null should be returned")
    public void testNullManufacturerFilter() {

    }

    @Test
    @DisplayName("Testing Aircraft Model Filter when items should be returned")
    public void testModelFilter() {

    }

    @Test
    @DisplayName("Testing Aircraft Model Filter when null should be returned")
    public void testNullModelFilter() {

    }

    @Test
    @DisplayName("Testing Aircraft Manufacturer Filter when items should be returned")
    public void testManufacturerFilter() {

    }

    //
    @Test
    @DisplayName("Testing Aircraft Owner Filter when null should be returned")
    public void testNullOwnerFilter() {

    }

    @Test
    @DisplayName("Testing Aircraft Owner Filter when items should be returned")
    public void testOwnerFilter() {

    }

}