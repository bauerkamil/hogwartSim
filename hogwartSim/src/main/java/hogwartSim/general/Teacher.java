package hogwartSim.general;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.map.IMap;

public class Teacher extends Wizard {
//    protected IMap map;
//    protected String house;
//    protected IDumbledore dumbledore;
    protected final int pointsForSameHouse = 50;
    protected final int pointsForDifferentHouse = -20;

    public Teacher(IMap map, HogwartHouses house, IDumbledore dumbledore) {
        super(map, house, dumbledore);
    }


    /**
     * Adds or removes points depending on the students's House
     * @param student Encountered student
     */
    public void meetStudent(Student student) {
        if (isTheSameHouse(this, student)){
            dumbledore.addPoints(student.house, pointsForSameHouse);
            System.out.println(student.house + " got " + pointsForSameHouse + " points");
        } else {
            dumbledore.addPoints(student.house, pointsForDifferentHouse);
        }
    }


}
