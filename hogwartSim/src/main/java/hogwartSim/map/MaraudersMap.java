package hogwartSim.map;

import hogwartSim.general.ICreature;
import hogwartSim.general.IItem;

import java.util.*;

public class MaraudersMap implements IMap {


    protected Random rnd;
//    protected long seed;
    private int mapSize;
//    private ICreature[] creatures;
    private Map<ICreature, PositionXY> creaturePosition;
//    private IItem[] items;
    private Map<IItem, PositionXY> itemPosition;


    /**
     * Creates a table for movable creatures and a map to remember their positions,
     * Creates a table for non-movable items (different type than ICreature)
     * @param mapSize The length of the map
     * @param seed A random seed
     */
    public MaraudersMap(int mapSize, long seed){

        this.mapSize = mapSize;

//        this.seed=seed;
        this.rnd = new Random(seed);
//        rnd.setSeed(seed);

        /**
         * Creates a table for movable creatures and a map to remember their positions
         */
//        creatures = new ICreature[mapSize];
        creaturePosition = new HashMap<ICreature, PositionXY>();
        /**
         * Creates a table for non-movable items (different type than ICreature)
         */
//        items = new IItem[mapSize];
        itemPosition = new HashMap<IItem, PositionXY>();
    }

    public List<ICreature> getCreatures(){
        return new ArrayList(creaturePosition.keySet());
    }


    /**
     * Gets new random position for the creature
     * @param creature Student, teacher or basilisk
     */
    public void randomLocate(ICreature creature) {
        creaturePosition.put(creature, this.getRandomPosition());
    }

    public void randomLocate(IItem item) {
        // TODO: Check if key doesn't exist in map already
        itemPosition.put(item, this.getRandomPosition());
    }

    public void randomRelocate(ICreature creature) {
        if(creaturePosition.containsKey(creature)) {
            creaturePosition.put(creature, this.getRandomPosition());
        }
    }

    protected PositionXY getRandomPosition() {
        int x = rnd.nextInt(mapSize);
        int y = rnd.nextInt(mapSize);
        return new PositionXY(x, y);
    }

    public List<ICreature> getAtPosition(PositionXY positionXY){
//        PositionXY givenPosition = creaturePosition.get(givenCreature);
//        /**
//         * iterate over each creature on the map
//         */
//        for(ICreature iCreature : creaturePosition.keySet()){
//            PositionXY iPosition = creaturePosition.get(iCreature);
//            /**
//             * check if the coordinates are the same as the given in @param givenCreature
//             * if so then return reference to it
//             */
//            if (iCreature != givenCreature){
//                // override equals for point
//                if(givenPosition.getX() == iPosition.getX() && givenPosition.getY() == iPosition.getY()){
//                    return iCreature;
//                }
//            }
//        }
        final List<ICreature> creaturesAtPosition = new ArrayList<>();

        creaturePosition.forEach((creature, positionXY1) -> {
            if(positionXY1.equals(positionXY)){
                creaturesAtPosition.add(creature);
            }
        });
        return creaturesAtPosition;
    }

    public List<IItem> getItemsAtPosition(PositionXY positionXY){
        final List<IItem> itemsAtPosition = new ArrayList<>();

        itemPosition.forEach((item, itemPositionXY) -> {
            if(itemPositionXY.equals(positionXY)){
                itemsAtPosition.add(item);
            }

        });
        return itemsAtPosition;
    }
    public PositionXY getPosition(ICreature creature){
        if(!creaturePosition.containsKey(creature)){
            throw new IllegalArgumentException("Creature not on map");
        }
        return creaturePosition.get(creature);
    }
    public IItem checkForItemPosition(ICreature givenCreature){
//        PositionXY givenPosition = creaturePosition.get(givenCreature);
//        /**
//         * iterate over each item on the map
//         */
//        for(IItem iitem : itemPosition.keySet()){
//            PositionXY iPosition = itemPosition.get(iitem);
//            /**
//             * check if the coordinates are the same as the given in @param givenCreature
//             * if so then return reference to it
//             */
//            if(givenPosition.getX() == iPosition.getX() && givenPosition.getY() == iPosition.getY())
//                return iitem;
//
//
//        }

        return null;
    }

    public void removeFromMap(ICreature creatureToRemove) {
        creaturePosition.remove(creatureToRemove);
    }
    public void removeFromMap(IItem itemToRemove){
        itemPosition.remove(itemToRemove);
    }
}