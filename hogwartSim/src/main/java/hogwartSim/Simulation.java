package hogwartSim;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.dumbledore.creator.DumbledoreCreator;
import hogwartSim.dumbledore.creator.IDumbledoreCreator;
import hogwartSim.general.ICreature;
import hogwartSim.general.IItem;
import hogwartSim.general.creator.GeneralCreator;
import hogwartSim.general.creator.IGeneralCreator;
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

    public Simulation(IMapCreator mapCreator, IGeneralCreator generalCreator, IDumbledoreCreator dumbledoreCreator, long seed, int maxIter) {
        map = mapCreator.createMap();
        dumbledore = dumbledoreCreator.createDumbledore();

        rnd = new Random(seed);
        creatureList = generalCreator.createCreatures(map);

        this.maxIter = maxIter;
    }

    /**
     * put creatures and items on the map
     */
    for (int i=0; i<creatureList.size(); i++) {
        map.changePosition(creatureList.get(i));
    }
    for(int j=0; i<itemList; j++) {
        map.changeItemPosition(itemList.get(i));
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

        MapCreator mapCreat = new MapCreator(10, 20);
        IGeneralCreator generalCreat = new GeneralCreator(8, 4);
        IDumbledoreCreator dumbledoreCreat = new DumbledoreCreator();
        Simulation sim = new Simulation(mapCreat, generalCreat, dumbledoreCreat, 1, 20);

        sim.runSimulation();

        System.out.println("END");
    }

}
