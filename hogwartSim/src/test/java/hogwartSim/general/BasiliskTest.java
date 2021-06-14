package hogwartSim.general;

import hogwartSim.dumbledore.Dumbledore;
import hogwartSim.map.MaraudersMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasiliskTest {

    @Test
    void kill() {
        //given
        MaraudersMap map = new MaraudersMap(1,1);
        Dumbledore dumbledore = new Dumbledore();
        Basilisk basilisk = new Basilisk(map);
        Student student = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        //when
        basilisk.kill(student);
        //then
        assertFalse(student.getIsAlive());
    }
}