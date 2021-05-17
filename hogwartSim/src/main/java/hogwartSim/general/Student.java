package hogwartSim.general;

import hogwartSim.map.IMap;

public class Student extends Wizard {

    protected IMap map;
    protected String house;

    public Student(IMap map, String house) {
        super(map, house);
    }

    public void useItem(IItem itemToUse){

    }
}
