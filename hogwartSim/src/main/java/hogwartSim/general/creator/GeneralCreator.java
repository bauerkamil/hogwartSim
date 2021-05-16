package hogwartSim.general.creator;

import hogwartSim.general.Basilisk;
import hogwartSim.general.ICreature;
import hogwartSim.general.Student;
import hogwartSim.general.Teacher;

import java.util.LinkedList;
import java.util.List;

public class GeneralCreator implements IGeneralCreator{

    protected int numStudents;
    protected int numTeachers;
    public GeneralCreator(int numStudents, int numTeachers){
        this.numStudents = numStudents;
        this.numTeachers = numTeachers;
    }

    @Override
    public List<ICreature> createCreatures() {
        List<ICreature> creatureList = new LinkedList<>();
        /**
         * create one basilisk
         */
        creatureList.add(new Basilisk());

        /**
         * create a number of students and teachers with a house sorted
         */
        for(int i = 0; i<numStudents; i++)
            creatureList.add(new Student(sortingHat(i)));

        for(int i = 0; i<numTeachers; i++)
            creatureList.add(new Teacher(sortingHat(i)));

        return creatureList;
    }

    public String sortingHat(int wizardNumber){
        /**
         * sort wizards into 4 houses, every fourth goes to the same house
         */
        if(wizardNumber % 4 == 0)
            return "Hogwarts";
        else if(wizardNumber % 4 == 1)
            return "Slytherin";
        else if(wizardNumber % 4 == 2)
            return "Hufflepuff";
        else
            return "Ravenclaw";
    }
}
