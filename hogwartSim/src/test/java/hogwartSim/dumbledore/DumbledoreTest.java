package hogwartSim.dumbledore;

import hogwartSim.general.HogwartHouses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DumbledoreTest {

    @Test
    void addPoints() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        //when
        dumbledore.addPoints(HogwartHouses.GRYFFINDOR, 50);
        //then
        Assertions.assertEquals(50, dumbledore.housesPoints[0]);
    }

    /*@Test
    void declareWinner() {
        //given
        Dumbledore dumbledore = new Dumbledore();
    }*/
}