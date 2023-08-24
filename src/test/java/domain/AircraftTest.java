package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AircraftTest {

    Aircraft aircraft = new Aircraft("Boeing", "747", "Ryan Air", 416);

    @Test
    @DisplayName("Testing Aircraft Getter")
    public void testGetter() {
        assertEquals("Ryan Air", aircraft.getAirlineOwner());
    }

    @Test
    @DisplayName("Testing Aircraft Setters")
    public void testSetters() {
        aircraft.setAirlineOwner("Aer Lingus");
        assertEquals("Aer Lingus", aircraft.getAirlineOwner());
    }

}