package hogwartSim.general;

import hogwartSim.interactions.InteractionAgent;
import hogwartSim.map.IMap;

public class Basilisk extends Creature implements IKill {
    protected IMap map;
    public Basilisk(IMap map){
        super(map);
    }

    public void kill(Student studentToKill) {
        studentToKill.die();
        map.removeFromMap(studentToKill);
    }

    /**
     * override move() method and give basilisk a double round
     */
    @Override
    public void move(){
        map.changePosition(this);
        InteractionAgent.action(this, map);

        map.changePosition(this);
        InteractionAgent.action(this, map);
    }

}
