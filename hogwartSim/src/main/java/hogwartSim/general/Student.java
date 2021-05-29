package hogwartSim.general;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.map.IMap;

public class Student extends Wizard {

    //protected IMap map;
    //protected String house;
    private boolean isAlive;

    public Student(IMap map, String house, IDumbledore dumbledore) {
        super(map, house, dumbledore);
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
        map.removeFromMap(item);
        dumbledore.addPoints(this.house, 20);
    }
}
