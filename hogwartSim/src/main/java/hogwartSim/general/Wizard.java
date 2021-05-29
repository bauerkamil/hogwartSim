package hogwartSim.general;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.map.IMap;

public abstract class Wizard extends Creature  {
    protected String house;
    protected IDumbledore dumbledore;

    public Wizard(IMap map, String house, IDumbledore dumbledore){
        super(map);
        this.house = house;
        this.dumbledore = dumbledore;
    }

    public boolean isTheSameHouse(Wizard wizard1, Wizard wizard2){
        if (wizard1.house == wizard2.house)
            return true;
        return false;
    }
}
