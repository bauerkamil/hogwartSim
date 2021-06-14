package hogwartSim.general;

import hogwartSim.dumbledore.Dumbledore;
import hogwartSim.map.MaraudersMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {

    @Test
    void isTheSameHouse_BothWizardsFromTheSameHouse() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        MaraudersMap map = new MaraudersMap(5,1);
        Wizard wizard1 = new Teacher(map, HogwartHouses.GRYFFINDOR, dumbledore);
        Wizard wizard2 = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        //then
        assertTrue(wizard1.isTheSameHouse(wizard1, wizard2));
        }
    @Test
    void isTheSameHouse_WizardsFromDifferentHouses() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        MaraudersMap map = new MaraudersMap(5,1);
        Wizard wizard1 = new Teacher(map, HogwartHouses.GRYFFINDOR, dumbledore);
        Wizard wizard2 = new Student(map, HogwartHouses.RAVENCLAW, dumbledore);
        //then
        assertFalse(wizard1.isTheSameHouse(wizard1, wizard2));
    }
    @Test
    void isTheSameHouse_BothStudentsFromTheSameHouse() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        MaraudersMap map = new MaraudersMap(5,1);
        Wizard wizard1 = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        Wizard wizard2 = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        //then
        assertTrue(wizard1.isTheSameHouse(wizard1, wizard2));
    }
    @Test
    void isTheSameHouse_StudentsFromDifferentHouses() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        MaraudersMap map = new MaraudersMap(5,1);
        Wizard wizard1 = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        Wizard wizard2 = new Student(map, HogwartHouses.RAVENCLAW, dumbledore);
        //then
        assertFalse(wizard1.isTheSameHouse(wizard1, wizard2));
    }
    @Test
    void isTheSameHouse_BothTeachersFromTheSameHouse() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        MaraudersMap map = new MaraudersMap(5,1);
        Wizard wizard1 = new Teacher(map, HogwartHouses.GRYFFINDOR, dumbledore);
        Wizard wizard2 = new Teacher(map, HogwartHouses.GRYFFINDOR, dumbledore);
        //then
        assertTrue(wizard1.isTheSameHouse(wizard1, wizard2));
    }
    @Test
    void isTheSameHouse_TeachersFromDifferentHouses() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        MaraudersMap map = new MaraudersMap(5,1);
        Wizard wizard1 = new Teacher(map, HogwartHouses.GRYFFINDOR, dumbledore);
        Wizard wizard2 = new Teacher(map, HogwartHouses.RAVENCLAW, dumbledore);
        //then
        assertFalse(wizard1.isTheSameHouse(wizard1, wizard2));
    }

}

