package hogwartSim.general;

import hogwartSim.map.IMap;

public abstract class Wizard extends Creature  {
    protected String house;

    public Wizard(IMap map, String house){
        super(map);
        this.house = house;
    }

    public boolean isTheSameHouse(Wizard wizard1, Wizard wizard2){
        if (wizard1.house == wizard2.house)
            return true;
        return false;
    }
}
