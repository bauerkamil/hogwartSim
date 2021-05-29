package hogwartSim.general;

import hogwartSim.interactions.InteractionAgent;
import hogwartSim.map.IMap;

public abstract class Creature implements ICreature {
    protected IMap map;
    public Creature(IMap map){
        this.map = map;
    }

    public void move() {
        /**
         * The following are why there is a protected IMap map
         * This allows function changePosition() to be non-static
         */
        map.randomRelocate(this);
        InteractionAgent.action(this, map);
    }
}
