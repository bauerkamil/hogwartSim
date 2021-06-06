package hogwartSim.general;

import hogwartSim.interactions.InteractionAgent;
import hogwartSim.map.IMap;

public class Basilisk extends Creature implements IKill {

    public Basilisk(IMap map){
        super(map);
    }

    /**
     * Kills the student
     * @param studentToKill The specific student to kill
     */
    public void kill(Student studentToKill) {
        studentToKill.die();
        map.removeFromMap(studentToKill);
        System.out.println("OH NO! The basilisk has killed a student. But don't worry, our school is perfectly safe.");
        System.out.println("*nervous laughter*");
        System.out.println("NOW GIVE US ALL YOUR CHILDREN");
    }

    /**
     * Overrides move() method and gives basilisk a double round
     */
    @Override
    public void move(){
        map.randomRelocate(this);
        InteractionAgent.action(this, map);

        map.randomRelocate(this);
        InteractionAgent.action(this, map);
    }

}
