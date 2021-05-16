package hogwartSim;

import hogwartSim.general.ICreature;
import hogwartSim.general.Item;
import hogwartSim.general.creator.IGeneralCreator;
import hogwartSim.map.IMap;
import hogwartSim.map.creator.IMapCreator;

import java.util.List;
import java.util.Random;

public class Simulation {
    private IMap map;
    private Random rnd;
    private List<ICreature> creatureList;
    private List<Item> itemList;
    private final int mapSize;
    private final int maxIter;

    public Simulation(IMapCreator mapCreator, IGeneralCreator generalCreator, long seed, int maxIter, int mapSize) {
        this.mapSize = mapSize;
        map = IMapCreator.createMap(this.mapSize);

        rnd = new Random(seed);
        creatureList = generalCreator.createCreatures(map);

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

    }

}
