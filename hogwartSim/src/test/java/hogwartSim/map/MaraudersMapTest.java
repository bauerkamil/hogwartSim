package hogwartSim.map;

import hogwartSim.dumbledore.Dumbledore;
import hogwartSim.general.ButterBeer;
import hogwartSim.general.HogwartHouses;
import hogwartSim.general.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MaraudersMapTest {

    @Test
    void getAtPosition() {
        //given
        MaraudersMap map = new MaraudersMap(5,1);
        Dumbledore dumbledore = new Dumbledore();
        PositionXY positionXY1 = new PositionXY(1,1);
        PositionXY positionXY2 = new PositionXY(1,1);
        Student student = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        //when
        map.creaturePosition.put(student,positionXY2);
        //then
        Assertions.assertEquals(map.getAtPosition(positionXY1).size(), 1);
    }

    @Test
    void getItemsAtPosition() {
        //given
        MaraudersMap map = new MaraudersMap(5,1);
        PositionXY positionXY1 = new PositionXY(1,1);
        PositionXY positionXY2 = new PositionXY(1,1);
        ButterBeer butterBeer1 = new ButterBeer(map);
        ButterBeer butterBeer2 = new ButterBeer(map);
        //when
        map.itemPosition.put(butterBeer1,positionXY2);
        map.itemPosition.put(butterBeer2,positionXY2);
        //then
        Assertions.assertEquals(map.getItemsAtPosition(positionXY1).size(), 2);
    }

    @Test
    void getPosition() {
        MaraudersMap map = new MaraudersMap(5,1);
        Dumbledore dumbledore = new Dumbledore();
        PositionXY positionXY1 = new PositionXY(1,1);
        Student student = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        //when
        map.creaturePosition.put(student,positionXY1);
        //then

        Assertions.assertEquals(map.getPosition(student), positionXY1);
    }
    @Test
    void getPositionException() {
        MaraudersMap map = new MaraudersMap(5, 1);
        Dumbledore dumbledore = new Dumbledore();
        //PositionXY positionXY1 = new PositionXY(1, 0);
        Student student = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        //when
        //map.creaturePosition.put(student, positionXY1);
        //then
        Assertions.assertThrows(IllegalArgumentException.class, ()-> map.getPosition(student));
    }
}