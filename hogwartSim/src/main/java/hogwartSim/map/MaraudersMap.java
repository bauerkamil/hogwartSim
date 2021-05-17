package hogwartSim.map;

import hogwartSim.general.ICreature;
import hogwartSim.general.IItem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class MaraudersMap implements IMap {


    protected Random rnd;
    protected long seed;
    private int mapSize;
    private ICreature[] creatures;
    private Map<ICreature, Point2d> creaturePosition;
    private IItem[] items;
    private Map<IItem, Point2d> itemPosition;

    public MaraudersMap(int mapSize, long seed){

        this.mapSize = mapSize;

        this.seed=seed;
        rnd.setSeed(seed);
        this.rnd = new Random(seed);
        /**
         * create movable creatures and a map to remember their positions
         * JAKA WIELKOŚĆ TABLICY?? (dwie kreatury mogą się pojawić na tym samym polu)
         */
        creatures = new ICreature[mapSize];
        creaturePosition = new HashMap<ICreature, Point2d>();
        /**
         * create non-movable items (different type than ICreatures)
         */
        items = new IItem[4];
        itemPosition = new HashMap<IItem, Point2d>();
    }

    public void changePosition(ICreature creature) {
        int positionX = rnd.nextInt(mapSize);
        int positionY = rnd.nextInt(mapSize);

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
    public IItem checkItemPosition(ICreature givenCreature){
        /**
         * iterate over each givenCreature on the map
         */
        for(IItem iitem : itemPosition.keySet()){
            /**
             * check if the coordinates are the same as the given in @param givenCreature
             * if so then return reference to it
             */
            if(itemPosition.get(iitem).equals(creaturePosition.get(givenCreature)))
                return iitem;


        }

        return null;
    }
}
