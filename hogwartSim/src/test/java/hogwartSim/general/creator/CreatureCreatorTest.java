package hogwartSim.general.creator;

import hogwartSim.dumbledore.Dumbledore;
import hogwartSim.general.HogwartHouses;
import hogwartSim.general.Student;
import hogwartSim.map.MaraudersMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CreatureCreatorTest {

    @Test
    void createCreatures() {
        //given
        MaraudersMap map = new MaraudersMap(3,1);
        Dumbledore dumbledore = new Dumbledore();
        CreatureCreator creatureCreator = new CreatureCreator(4,0);
        //when
        creatureCreator.createCreatures(map, dumbledore);
        //then
        Assertions.assertEquals( creatureCreator.createCreatures(map, dumbledore).size(), 5);
        // 5 objects because automatically there is one basilisk created
    }

    @Test
    void sortingHat() {
        //given
        CreatureCreator creatureCreator = new CreatureCreator(0,0);
        Dumbledore dumbledore = new Dumbledore();
        MaraudersMap map = new MaraudersMap(5,1);
        //when
        Student student = new Student(map, creatureCreator.sortingHat(1), dumbledore);
        //then
        Assertions.assertEquals(student.getHouse(), HogwartHouses.SLYTHERIN);
    }
}