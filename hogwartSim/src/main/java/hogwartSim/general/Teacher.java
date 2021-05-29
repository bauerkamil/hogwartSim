package hogwartSim.general;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.map.IMap;

public class Teacher extends Wizard {
//    protected IMap map;
//    protected String house;
//    protected IDumbledore dumbledore;

    public Teacher(IMap map, String house, IDumbledore dumbledore) {
        super(map, house, dumbledore);
    }



    public void meetStudent(Student student) {
        if (isTheSameHouse(this, student)){
            dumbledore.addPoints(student.house, 20);
            System.out.println(student.house + "got 20 points");
        } else {
            dumbledore.addPoints(student.house, -20);
        }
    }


}
