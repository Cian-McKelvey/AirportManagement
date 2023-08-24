package websocket;

import com.google.gson.Gson;
import domain.Aircraft;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

// Converts the aircraft objects to json so they can be sent
public class AircraftEncoder implements Encoder.Text<Aircraft> {

    private static Gson gson = new Gson();

    @Override
    public String encode(Aircraft aircraft) throws EncodeException {
        return gson.toJson(aircraft);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }

}