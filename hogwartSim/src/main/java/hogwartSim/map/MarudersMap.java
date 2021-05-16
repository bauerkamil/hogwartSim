package hogwartSim.map;

import hogwartSim.general.ICreature;

import java.awt.geom.Point2D;
import java.util.*;

public class MarudersMap implements IMap {


    protected Random rnd;
    protected long seed = 0;
    private ICreature[] creatures;
    private Map<ICreature, Point2D.Double> creaturePosition;

    public MarudersMap(int mapSize){
        creatures = new ICreature[mapSize];
        creaturePosition=new HashMap<>();
    }

    public static void changePosition(ICreature creature) {

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
