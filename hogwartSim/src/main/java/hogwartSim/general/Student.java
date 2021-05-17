package hogwartSim.general;

import hogwartSim.map.IMap;

public class Student extends Wizard implements IItem {

    protected IMap map;
    protected String house;

    public Student(IMap map, String house) {
        super(map, house);
    }
}
