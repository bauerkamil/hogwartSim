package hogwartSim.general;

import hogwartSim.map.IMap;

public class Teacher extends Wizard implements IPointGetter {
    protected IMap map;
    protected String house;

    public Teacher(IMap map, String house) {
        super(map, house);
    }


    public void changePointNumber(Student student1) {
    }


}
