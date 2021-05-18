package hogwartSim.map;

import hogwartSim.general.ICreature;
import hogwartSim.general.IItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MaraudersMap implements IMap {


    protected Random rnd;
    protected long seed;
    private int mapSize;
    private ICreature[] creatures;
    private Map<ICreature, PositionXY> creaturePosition;
    private IItem[] items;
    private Map<IItem, PositionXY> itemPosition;

    public MaraudersMap(int mapSize, long seed){

        this.mapSize = mapSize;

        this.seed=seed;
        rnd.setSeed(seed);
        this.rnd = new Random(seed);
        /**
         * create table for movable creatures and a map to remember their positions
         * JAKA WIELKOŚĆ TABLICY?? (dwie kreatury mogą się pojawić na tym samym polu)
         * Jest ona w ogóle potrzebna?
         */
        creatures = new ICreature[mapSize];
        creaturePosition = new HashMap<ICreature, PositionXY>();
        /**
         * create table for 4 non-movable items (different type than ICreature)
         */
        items = new IItem[mapSize];
        itemPosition = new HashMap<IItem, PositionXY>();
    }


    public void changePosition(ICreature creature) {
        /**
         * randomize 2D position within map range
         */
        int positionX = rnd.nextInt(mapSize);
        int positionY = rnd.nextInt(mapSize);
        /**
         * change the position of @param creature
          */
        creaturePosition.put(creature, new PositionXY(positionX, positionY));


    }
    public void changeItemPosition(IItem item) {
        /**
         * randomize 2D position within map range
         */
        int positionX = rnd.nextInt(mapSize);
        int positionY = rnd.nextInt(mapSize);
        /**
         * change the position of @param creature
         */
        itemPosition.put(item, new PositionXY(positionX, positionY));
    }
    public ICreature checkPosition(ICreature givenCreature){
        /**
         * iterate over each creature on the map
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
    public IItem checkForItemPosition(ICreature givenCreature){
        /**
         * iterate over each item on the map
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

    public void removeFromMap(ICreature creatureToRemove) {
        creaturePosition.remove(creatureToRemove);
    }
    public void removeItemFromMap(IItem itemToRemove){
        itemPosition.remove(itemToRemove);
    }
}