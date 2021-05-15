package hogwartSim;

import hogwartSim.*;
import hogwartSim.general.ICreature;
import hogwartSim.general.creator.IGeneralCreator;
import hogwartSim.map.IMap;
import hogwartSim.map.creator.IMapCreator;

import java.util.List;
import java.util.Random;

public class Simulation {
    private IMap map;
    private Random rnd;
    private List<ICreature> generalList;
    private int maxIter;

    public Simulation (hogwartSim.map.creator.IMapCreator mapCreator, IGeneralCreator generalCreator, long seed, int maxIter) {
        map = IMapCreator.createMap();
        rnd = new Random(seed);
        generalList = generalCreator.createCreatures(map);
        for (int i = 0; i < generalList.size(); i++) {
            //while (!map.settleSpecimen(specList.get(i), rnd.nextInt(map.getSize()))) ;
        }
        this.maxIter = maxIter;
    }

}
