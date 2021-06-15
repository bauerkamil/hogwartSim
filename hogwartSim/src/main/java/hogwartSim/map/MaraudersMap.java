package hogwartSim.map;

import hogwartSim.general.ICreature;
import hogwartSim.general.IItem;

import java.util.*;

/**
 * Class associated with map
 */
public class MaraudersMap implements IMap {


    protected Random rnd;
    private int mapSize;
    protected Map<ICreature, PositionXY> creaturePosition;
    protected Map<IItem, PositionXY> itemPosition;


    /**
     * Creates a table for movable creatures and a map to remember their positions,
     * Creates a table for non-movable items (different type than ICreature)
     * @param mapSize The size of the map
     * @param seed A random seed
     */
    public MaraudersMap(int mapSize, long seed){

        this.mapSize = mapSize;

        this.rnd = new Random(seed);

        creaturePosition = new HashMap<ICreature, PositionXY>();

        itemPosition = new HashMap<IItem, PositionXY>();
    }

    /**
     * get just the creatures from map
     * @return
     */
    public List<ICreature> getCreatures(){
        return new ArrayList(creaturePosition.keySet());
    }


    /**
     * Locates the creatureToBePositioned on a new random position
     * @param creatureToBePositioned Student, teacher or basilisk
     */
    public void randomLocate(ICreature creatureToBePositioned) {
        creaturePosition.put(creatureToBePositioned, this.getRandomPosition());
    }

    /**
     * Locates the itemToBePositioned on a new random position
     * @param itemToBePositioned Butterbeer
     */
    public void randomLocate(IItem itemToBePositioned) {
        // TODO: Check if key doesn't exist in map already
        itemPosition.put(itemToBePositioned, this.getRandomPosition());
    }


    /**
     * Changes the creature position into a new random one
     * @param creature Student, teacher or basilisk
     */
    public void randomRelocate(ICreature creature) {
        if(creaturePosition.containsKey(creature)) {
            creaturePosition.put(creature, this.getRandomPosition());
        }
    }

    /**
     * Gets random coordinates
     * @return Returns position with coordinates new random x and y
     */
    protected PositionXY getRandomPosition() {
        int x = rnd.nextInt(mapSize);
        int y = rnd.nextInt(mapSize);
        return new PositionXY(x, y);
    }

    /**
     * Gets all creatures on given position at the moment
     * @param positionXY position to be checked
     * @return Returns arrayList with the creatures
     */
    public List<ICreature> getAtPosition(PositionXY positionXY){

        final List<ICreature> creaturesAtPosition = new ArrayList<>();

        creaturePosition.forEach((creature, positionXY1) -> {
            if(positionXY1.equals(positionXY)){
                creaturesAtPosition.add(creature);
            }
        });
        return creaturesAtPosition;
    }

    /**
     * Gets  all items on given position
     * @param positionXY position to be checked
     * @return Returns arrayList with the items
     */
    public List<IItem> getItemsAtPosition(PositionXY positionXY){
        final List<IItem> itemsAtPosition = new ArrayList<>();

        itemPosition.forEach((item, itemPositionXY) -> {
            if(itemPositionXY.equals(positionXY)){
                itemsAtPosition.add(item);
            }

        });
        return itemsAtPosition;
    }

    /**
     * Checks and returns the position
     * @param creature Student, teacher or basilisk
     * @return Returns creature's position
     */
    public PositionXY getPosition(ICreature creature){
        if(!creaturePosition.containsKey(creature)){
            throw new IllegalArgumentException("Creature not on map");
        }
        return creaturePosition.get(creature);
    }


    /**
     * Removes chosen creature from map
     * @param creatureToRemove Specific creature to remove
     */
    public void removeFromMap(ICreature creatureToRemove) {
        creaturePosition.remove(creatureToRemove);
    }

    /**
     * Removes chosen item from map
     * @param itemToRemove Specific item to remove
     */
    public void removeFromMap(IItem itemToRemove){
        itemPosition.remove(itemToRemove);
    }
}