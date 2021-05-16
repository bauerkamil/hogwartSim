package hogwartSim;

import hogwartSim.general.ICreature;
import hogwartSim.general.creator.IGeneralCreator;
import hogwartSim.map.IMap;
import hogwartSim.map.creator.IMapCreator;

import java.util.List;
import java.util.Random;

public class Simulation {
    private IMap map;
    private Random rnd;
    private List<ICreature> creatureList;
    private final int mapSize;
    private int maxIter;

    public Simulation(IMapCreator mapCreator, IGeneralCreator generalCreator, long seed, int maxIter, int mapSize) {
        this.mapSize = mapSize;
        map = IMapCreator.createMap(this.mapSize);
        rnd = new Random(seed);
        creatureList = generalCreator.createCreatures(map);
        for (int cycleNumber = 0; cycleNumber < maxIter; cycleNumber++) {
            //while (!map.settleSpecimen(specList.get(i), rnd.nextInt(map.getSize()))) ;
        }
    }

}
