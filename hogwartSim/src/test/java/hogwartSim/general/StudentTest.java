package hogwartSim.general;

import hogwartSim.dumbledore.Dumbledore;
import hogwartSim.map.MaraudersMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void die() {
        //given
        MaraudersMap map = new MaraudersMap(1,1);
        Dumbledore dumbledore = new Dumbledore();
        Student student = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        //when
        student.die();
        //then
        assertFalse(student.getIsAlive());
    }

    @Test
    void use() {
        //given
        MaraudersMap map = new MaraudersMap(1,1);
        Dumbledore dumbledore = new Dumbledore();
        Student student = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        ButterBeer butterBeer = new ButterBeer(map);
        //when
        student.use(butterBeer);
        //then
        assertTrue(butterBeer.isUsed);
    }
}