package hogwartSim.general;

import hogwartSim.interactions.InteractionAgent;
import hogwartSim.map.IMap;

/**
 * Abstract class associated with movement
 */
public abstract class Creature implements ICreature {
    protected IMap map;
    public Creature(IMap map){
        this.map = map;
    }

    /**
     * Changes location of the object
     */
    public void move() {

        map.randomRelocate(this);
        InteractionAgent.action(this, map);
    }
}
