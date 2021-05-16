package hogwartSim.general;

import hogwartSim.map.MarudersMap;

public abstract class Creature implements ICreature {

    public void move() {
        MarudersMap.changePosition(this);
    }
}
