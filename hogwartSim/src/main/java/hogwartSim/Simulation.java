package hogwartSim;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.dumbledore.creator.DumbledoreCreator;
import hogwartSim.dumbledore.creator.IDumbledoreCreator;
import hogwartSim.general.ICreature;
import hogwartSim.general.IItem;
import hogwartSim.general.creator.CreatureCreator;
import hogwartSim.general.creator.ICreatureCreator;
import hogwartSim.general.creator.IItemCreator;
import hogwartSim.general.creator.ItemCreator;
import hogwartSim.map.IMap;
import hogwartSim.map.creator.IMapCreator;
import hogwartSim.map.creator.MapCreator;

import java.util.List;
import java.util.Random;


/**
 * The class responsible for running the simulation
 */
public class Simulation {
    private IMap map;
    private IDumbledore dumbledore;
    private Random rnd;
    private List<ICreature> creatureList;
    private List<IItem> itemList;
    private final int maxIter;

    public Simulation(MapCreator mapCreator, ICreatureCreator creatureCreator, IItemCreator itemCreator, IDumbledoreCreator dumbledoreCreator, long seed, int maxIter) {
        map = mapCreator.createMap();
        dumbledore = dumbledoreCreator.createDumbledore();

        rnd = new Random(seed);
//        rnd.setSeed(seed);
        creatureList = creatureCreator.createCreatures(map, dumbledore);

        itemList = itemCreator.createItems(map);

        this.maxIter = maxIter;


        /**
         * Puts creatures and items on the map
         */
        for (int i = 0; i < creatureList.size(); i++) {
            map.randomLocate(creatureList.get(i));
        }
        for (int j = 0; j < itemList.size(); j++) {
            map.randomLocate(itemList.get(j));
//            map.changeItemPosition(itemList.get(j));
        }
    }

    /**
     * Runs the simulation
     */
    public void runSimulation() {

        /**
         * Repeats cycles until maximum number of iterations is reached
         */
        for (int cycleNumber = 0; cycleNumber < maxIter; cycleNumber++) {
            /**
             * Moves each creature on the list
             */
            for(ICreature iCreature : map.getCreatures()){
                iCreature.move();
            }
        }
        dumbledore.declareWinner();

    }
//    public void removeFromCreatureList(ICreature creatureToRemove){
//        creatureList.remove(creatureToRemove);
//    }

    public static void main(String[] args){

        MapCreator mapCreator = new MapCreator(20, 20);
        ICreatureCreator creatureCreator = new CreatureCreator(12, 4);
        IItemCreator itemCreator = new ItemCreator(5);
        IDumbledoreCreator dumbledoreCreator = new DumbledoreCreator();
        Simulation sim = new Simulation(mapCreator, creatureCreator, itemCreator, dumbledoreCreator, 1, 200);

        sim.runSimulation();

        System.out.println("END");
    }

}
