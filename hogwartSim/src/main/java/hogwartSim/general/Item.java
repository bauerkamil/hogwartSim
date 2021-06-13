package hogwartSim.general;

import hogwartSim.map.IMap;

/**
 * Abstract class associated with usage of butterbeers, might be expanded in the future
 */
public abstract class Item implements IItem {
    protected boolean isUsed;
    protected IMap map;

    public Item(IMap map){
        this.map = map;
        this.isUsed = true;
    }

    /**
     * Changes a state of the used item to false
     */
    public void getUsed(){
        this.isUsed = false;
    }

}
