package hogwartSim.general.creator;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.general.*;
import hogwartSim.map.IMap;

import java.util.LinkedList;
import java.util.List;

/**
 * Class to create students, teachers and basilisk
 */
public class CreatureCreator implements ICreatureCreator {

    protected int numStudents;
    protected int numTeachers;

    public CreatureCreator(int numStudents, int numTeachers){
        this.numStudents = numStudents;
        this.numTeachers = numTeachers;
    }

    /**
     * Creates a basilisk, students and teachers
     * @param map The map where the objects are placed
     * @param dumbledore The object that calculates points got by certain objects
     * @return Returns a list of creatures
     */
    @Override
    public List<ICreature> createCreatures(IMap map, IDumbledore dumbledore) {
        List<ICreature> creatureList = new LinkedList<>();
        /**
         * Creates one basilisk
         */
        creatureList.add(new Basilisk(map));

        /**
         * Creates a number of students and teachers with a house sorted
         */
        for(int i = 0; i<numStudents; i++)
            creatureList.add(new Student(map, sortingHat(i), dumbledore));

        for(int i = 0; i<numTeachers; i++)
            creatureList.add(new Teacher(map, sortingHat(i), dumbledore));

        return creatureList;
    }

    public HogwartHouses sortingHat(int wizardNumber){
        /**
         * sort wizards into 4 houses, every fourth goes to the same house
         */
        return HogwartHouses.valueOfHouse(wizardNumber % HogwartHouses.size());}
//        if(wizardNumber % 4 == 0)
//            return "Gryffindor";
//        else if(wizardNumber % 4 == 1)
//            return "Slytherin";
//        else if(wizardNumber % 4 == 2)
//            return "Hufflepuff";
//        else
//            return "Ravenclaw";
    /**
     * Sorts wizards into 4 houses, every fourth goes to the same house
     * @param wizardNumber The number that is decisive to choose the House
     * @return Returns the chosen House
     */
//    public String sortingHat(int wizardNumber){
//
//        if(wizardNumber % 4 == 0)
//            return "Gryffindor";
//        else if(wizardNumber % 4 == 1)
//            return "Slytherin";
//        else if(wizardNumber % 4 == 2)
//            return "Hufflepuff";
//        else
//            return "Ravenclaw";
//    }
}
