package hogwartSim.map;

import hogwartSim.general.ICreature;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MaraudersMap implements IMap {


    protected Random rnd;
    protected long seed;
    protected int mapSize;
    private ICreature[] creatures;
    private Map<ICreature, Point2d> creaturePosition;

    public MaraudersMap(int mapSize, long seed){
        this.mapSize = mapSize;
        this.seed=seed;
        rnd.setSeed(seed);
        this.rnd = new Random(seed);
        creatures = new ICreature[mapSize];
        creaturePosition=new HashMap<>();
    }

    public void changePosition(ICreature creature) {
        int positionX = rnd.nextInt(mapSize);

    }
    public ICreature checkPosition(ICreature givenCreature){
        /**
         * iterate over each givenCreature on the map
         */
        for(ICreature iCreature : creaturePosition.keySet()){
            /**
             * check if the coordinates are the same as the given in @param givenCreature
             * if so then return reference to it
             */
            if(creaturePosition.get(iCreature).equals(creaturePosition.get(givenCreature)))
                return iCreature;

        }
        return null;
    }
}
