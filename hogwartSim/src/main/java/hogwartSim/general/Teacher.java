package hogwartSim.general;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.map.IMap;

public class Teacher extends Wizard {

    protected final int pointsForSameHouse = 50;
    protected final int pointsForDifferentHouse = -20;

    public Teacher(IMap map, HogwartHouses house, IDumbledore dumbledore) {
        super(map, house, dumbledore);
    }


    /**
     * Adds or removes points depending on the student's House
     * @param student Encountered student
     */
    public void meetStudent(Student student) {
        if (isTheSameHouse(this, student)){
            dumbledore.addPoints(student.getHouse(), pointsForSameHouse);
            System.out.println(student.getHouse() + " got " + pointsForSameHouse + " points");
        } else {
            dumbledore.addPoints(student.getHouse(), pointsForDifferentHouse);
            System.out.println(student.getHouse() + " got " + pointsForDifferentHouse + " points, just because the teacher prefers a different house.");
        }
    }


}
