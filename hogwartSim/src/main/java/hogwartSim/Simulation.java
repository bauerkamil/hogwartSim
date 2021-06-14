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
 * Class responsible for running the simulation
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

        creatureList = creatureCreator.createCreatures(map, dumbledore);

        itemList = itemCreator.createItems(map);

        this.maxIter = maxIter;

//        Puts creatures and items on the map
        for (int i = 0; i < creatureList.size(); i++) {
            map.randomLocate(creatureList.get(i));
        }
        for (int j = 0; j < itemList.size(); j++) {
            map.randomLocate(itemList.get(j));

        }
    }

    /**
     * Runs the simulation
     */
    public void runSimulation() {

//        Repeats cycles until maximum number of iterations is reached
        for (int cycleNumber = 0; cycleNumber < maxIter; cycleNumber++) {

            System.out.println(cycleNumber+1 + " day");

//            Moves each creature on the list
            for(ICreature iCreature : map.getCreatures()){
                iCreature.move();
            }

            dumbledore.HousesChart();
        }
        System.out.println(dumbledore.declareWinner() + " wins the House Cup \r\nTotal number of points:");
        dumbledore.HousesChart();

    }

    /**
     * starting method
     * @param args
     */
    public static void main(String[] args){

        int numBeers = 5;
        long seed = 20;

        if (args.length != 4){
            System.out.println("Please declare 4 initial values for following numbers:");
            System.out.println("map size, number of: students, teachers and iterations");
            System.exit(0);
        }

        int[] valueOfArgs = new int[args.length];

        try{
            for(int i = 0; i < valueOfArgs.length; ++i){
                valueOfArgs[i] = Integer.parseInt(args[i]);
            }
        }
        catch (Exception c){
            System.out.println("Parsing failed.");
            System.exit(0);
        }

        MapCreator mapCreator = new MapCreator(valueOfArgs[0], seed);
        ICreatureCreator creatureCreator = new CreatureCreator(valueOfArgs[1], valueOfArgs[2]);
        IItemCreator itemCreator = new ItemCreator(numBeers);
        IDumbledoreCreator dumbledoreCreator = new DumbledoreCreator();
        Simulation sim = new Simulation(mapCreator, creatureCreator, itemCreator, dumbledoreCreator, seed, valueOfArgs[3]);

        sim.runSimulation();

        System.out.println("END");
    }

}
