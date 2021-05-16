package hogwartSim.general;

import hogwartSim.map.IMap;

public class Student extends Wizard implements IUseItem {

    protected String house;

    public Student(String house) {
        super(house);
    }
}
