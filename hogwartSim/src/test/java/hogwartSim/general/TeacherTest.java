package hogwartSim.general;

import hogwartSim.dumbledore.Dumbledore;
import hogwartSim.map.MaraudersMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void meetStudentFromTheSameHouse() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        MaraudersMap map = new MaraudersMap(5,1);
        Teacher teacher = new Teacher(map, HogwartHouses.RAVENCLAW, dumbledore);
        Student student = new Student(map, HogwartHouses.RAVENCLAW, dumbledore);
        //when
        teacher.meetStudent(student);
        teacher.meetStudent(student); //Making sure to win with Gryffindor
        //then
        Assertions.assertEquals(dumbledore.declareWinner(), HogwartHouses.RAVENCLAW);
    }
    @Test
    void meetStudentFromDifferentHouse() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        MaraudersMap map = new MaraudersMap(5,1);
        Teacher teacher = new Teacher(map, HogwartHouses.RAVENCLAW, dumbledore);
        Student student = new Student(map, HogwartHouses.GRYFFINDOR, dumbledore);
        //when
        teacher.meetStudent(student);
        teacher.meetStudent(student);
        teacher.meetStudent(student); //Making sure that Gryffindor will lose
        //then
        Assertions.assertEquals(dumbledore.declareWinner(), HogwartHouses.HUFFLEPUFF);
    }

}