package websocket;

import com.google.gson.Gson;
import domain.Aircraft;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class AircraftDecoder implements Decoder.Text<Aircraft> {

    private static Gson gson = new Gson();

    @Override
    public Aircraft decode(String s) throws DecodeException {
        return gson.fromJson(s, Aircraft.class);
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
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