package hogwartSim.general;

import hogwartSim.map.IMap;

public class Basilisk extends Creature implements IKill {
    protected IMap map;
    public Basilisk(IMap map){
        super(map);
    }

    public void kill(Student studentToKill) {

    }

}
