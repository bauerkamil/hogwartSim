package hogwartSim.general;

import hogwartSim.map.IMap;

public abstract class Wizard extends Creature  {
    protected String house;

    public Wizard(IMap map, String house){
        super(map);
        this.house = house;
    }
}
