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

public class Simulation {
    private IMap map;
    private IDumbledore dumbledore;
    private Random rnd;
    private List<ICreature> creatureList;
    private List<IItem> itemList;
    private final int maxIter;

    public Simulation(IMapCreator mapCreator, ICreatureCreator creatureCreator, IItemCreator itemCreator, IDumbledoreCreator dumbledoreCreator, long seed, int maxIter) {
        map = mapCreator.createMap();
        dumbledore = dumbledoreCreator.createDumbledore();

        rnd = new Random(seed);
        rnd.setSeed(seed);
        creatureList = creatureCreator.createCreatures(map);

        itemList = itemCreator.createItems(map);

        this.maxIter = maxIter;


        /**
         * put creatures and items on the map
         */
        for (int i = 0; i < creatureList.size(); i++) {
            map.changePosition(creatureList.get(i));
        }
        for (int j = 0; j < itemList.size(); j++) {
            map.changeItemPosition(itemList.get(j));
        }
    }

    public void runSimulation() {

        /**
         * repeat cycles until maximum number of iterations is reached
         */
        for (int cycleNumber = 0; cycleNumber < maxIter; cycleNumber++) {
            /**
             * move each creature on the list
             */
            for(ICreature iCreature : creatureList){
                iCreature.move();
            }
        }
        dumbledore.declareWinner();

    }
    public void removeFromCreatureList(ICreature creatureToRemove){
        creatureList.remove(creatureToRemove);
    }

    public static void main(String[] args){

        MapCreator mapCreator = new MapCreator(20, 20);
        ICreatureCreator creatureCreator = new CreatureCreator(12, 4);
        IItemCreator itemCreator = new ItemCreator(5);
        IDumbledoreCreator dumbledoreCreator = new DumbledoreCreator();
        Simulation sim = new Simulation(mapCreator, creatureCreator, itemCreator, dumbledoreCreator, 1, 40);

        sim.runSimulation();

        System.out.println("END");
    }

}
