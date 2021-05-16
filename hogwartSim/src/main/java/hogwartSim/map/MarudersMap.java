package hogwartSim.map;

import hogwartSim.general.ICreature;


import java.awt.geom.Point2D;
import java.util.*;

public class MarudersMap {


    protected Random rnd1;
    protected long seed = 0;
    private ICreature[] creatures;
    private Map<ICreature, Point2D.Double> generalPosition;

    public MarudersMap(int mapSize) {
        creatures = new ICreature[mapSize];
        generalPosition=new HashMap<>();
    }

    public void changePosition(ICreature creature) {

    }
    public void checkPosition(ICreature creature){
        /**
         * iterate over each creature on the map
         */
        for(ICreature i : generalPosition.keySet()){
            /**
             * check if the coordinates are the same as the given in @param creature
             */
            if(generalPosition.get(i).equals(generalPosition.get(creature)))
                InteractionAgent.action(creature, i);

        }

    }
}
