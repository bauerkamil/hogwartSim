package hogwartSim.general;

import hogwartSim.map.IMap;

/**
 * The abstract class associated with usage of butterbeers
 */
public abstract class Item implements IItem {
    protected boolean isUsed;
    protected IMap map;

    public Item(IMap map){
        this.map = map;
        this.isUsed = true;
    }

    /**
     * Changes a state of the used object to false
     */
    public void getUsed(){
        this.isUsed = false;
    }

//    public void meetStudent(Student student){}
}
