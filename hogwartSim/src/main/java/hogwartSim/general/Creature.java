package hogwartSim.general;

import hogwartSim.interactions.InteractionAgent;
import hogwartSim.map.MarudersMap;

public abstract class Creature implements ICreature {

    public void move() {
        MarudersMap.changePosition(this);
        InteractionAgent.action(this);
    }
}
