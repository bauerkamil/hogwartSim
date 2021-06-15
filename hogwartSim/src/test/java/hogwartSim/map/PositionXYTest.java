package hogwartSim.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionXYTest {

    @Test
    void testEquals_assertTrue() {
        PositionXY positionXY1 = new PositionXY(1,1);
        PositionXY positionXY2 = new PositionXY(1,1);
        assertTrue(positionXY1.equals(positionXY2));

    }
    @Test
    void testEquals_assertFalse() {
        PositionXY positionXY1 = new PositionXY(2,1);
        PositionXY positionXY2 = new PositionXY(3,7);
        assertFalse(positionXY1.equals(positionXY2));

    }
}