package websocket;

import domain.Aircraft;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppEndpointTest {

    String aircraftJson = "{\"airline\":\"American Airlines\",\"manufacturer\":\"Boeing\",\"model\":\"747\",\"numSeats\":416}";
    Aircraft aircraft = jsonToAircraft(aircraftJson);

    @Test
    @DisplayName("Test Json To Aircraft Object Method")
    public void testJsonToAircraft() {
        assertEquals("American Airlines", aircraft.getAirlineOwner());
    }




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
