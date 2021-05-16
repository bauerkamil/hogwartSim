package hogwartSim;

import hogwartSim.general.ICreature;
import hogwartSim.general.Item;
import hogwartSim.general.creator.GeneralCreator;
import hogwartSim.general.creator.IGeneralCreator;
import hogwartSim.map.IMap;
import hogwartSim.map.creator.IMapCreator;
import hogwartSim.map.creator.MapCreator;

import java.util.List;
import java.util.Random;

public class Simulation {
    private IMap map;
    private Random rnd;
    private List<ICreature> creatureList;
    private List<Item> itemList;
    private final int maxIter;

    public Simulation(IMapCreator mapCreator, IGeneralCreator generalCreator, long seed, int maxIter) {
        map = IMapCreator.createMap();

        rnd = new Random(seed);
        creatureList = generalCreator.createCreatures();

        this.maxIter = maxIter;
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
    }
    public static void main(String[] args){

        MapCreator mapCreat = new MapCreator(10);
        IGeneralCreator generalCreat = new GeneralCreator(8, 4);
        Simulation sim = new Simulation(mapCreat, generalCreat, 1, 20);

        sim.runSimulation();

        System.out.println("END");
    }

}
