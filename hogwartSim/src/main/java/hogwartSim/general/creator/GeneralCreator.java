package hogwartSim.general.creator;

import hogwartSim.general.ICreature;
import hogwartSim.general.Student;
import hogwartSim.map.IMap;

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
    public List<ICreature> createCreatures(IMap map) {
        List<ICreature> creatureList = new LinkedList<>();

        for(int i = 0; i<numStudents; i++)
            creatureList.add(new Student(sortingHat()));

        return creatureList;
    }

    public String sortingHat(){

        return null;
    }
}
