package hogwartSim.general;

import hogwartSim.map.IMap;

public class Student extends Wizard {

    //protected IMap map;
    //protected String house;
    private boolean isAlive;

    public Student(IMap map, String house) {
        super(map, house);
        this.isAlive = true;
    }

    public boolean getIsAlive(){return this.isAlive;}

    public String getHouse() {
        return house;
    }

    public void die(){
        this.isAlive = false;
    }

    public void use(IItem item) {
        item.getUsed();
        map.removeItemFromMap(item);
    }
}
