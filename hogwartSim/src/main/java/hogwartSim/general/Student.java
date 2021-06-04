package hogwartSim.general;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.map.IMap;

public class Student extends Wizard {

    //protected IMap map;
    //protected String house;
    private boolean isAlive;
    protected final int pointsForBeer = 20;

    public Student(IMap map, String house, IDumbledore dumbledore) {
        super(map, house, dumbledore);
        this.isAlive = true;
    }

    public boolean getIsAlive(){return this.isAlive;}

    public String getHouse() {
        return house;
    }

    /**
     * Changes a state of the object to false
     */
    public void die(){
        this.isAlive = false;
    }

    /**
     * Uses the item, changes its state to false, removes the item from the map, adds points
     * @param item The item that is being used
     */
    public void use(IItem item) {
        item.getUsed();
        map.removeFromMap(item);
        dumbledore.addPoints(this.house, pointsForBeer);
    }

    /**
     * Checkes if is alive and moves to another location
     */
    public void move(){
        if(!isAlive){
            return;
        }
        super.move();
    }
}
