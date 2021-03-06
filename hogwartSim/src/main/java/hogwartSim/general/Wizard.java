package hogwartSim.general;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.map.IMap;

/**
 * Abstract class, that has a house parameter
 */
public abstract class Wizard extends Creature  {
    protected HogwartHouses house;
    protected IDumbledore dumbledore;

    public Wizard(IMap map, HogwartHouses house, IDumbledore dumbledore){
        super(map);
        this.house = house;
        this.dumbledore = dumbledore;
    }

    /**
     * Checks if two objects share the same House value
     * @param wizard1 The first wizard
     * @param wizard2 The second wizard
     * @return Returns true or false
     */
    public boolean isTheSameHouse(Wizard wizard1, Wizard wizard2){
        if (wizard1.house == wizard2.house)
            return true;
        return false;
    }
}
