package hogwartSim.general;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.map.IMap;

public class Student extends Wizard {

    private boolean isAlive;
    protected final int pointsForBeer = 20;

    public Student(IMap map, HogwartHouses house, IDumbledore dumbledore) {
        super(map, house, dumbledore);
        this.isAlive = true;
    }

    /**
     * get state of student, whether alive or not
     * @return
     */
    public boolean getIsAlive(){return this.isAlive;}

    /**
     * get house of the student
     * @return
     */
    public HogwartHouses getHouse() {
        return house;
    }

    /**
     * Changes a state of the object to isAlive=false
     */
    public void die(){
        this.isAlive = false;
    }

    /**
     * Uses the itemToBeUsed, removes the itemToBeUsed from the map, adds points
     * @param itemToBeUsed
     */
    public void use(IItem itemToBeUsed) {
        itemToBeUsed.getUsed();
        map.removeFromMap(itemToBeUsed);
        dumbledore.addPoints(this.house, pointsForBeer);
        System.out.println("Student drunk. Student happy. Student finds point record and add themselves some points");
    }

    /**
     * Checks if the student is alive and if so moves to another location
     */
    public void move(){
        if(!isAlive){
            return;
        }
        super.move();
    }
}
