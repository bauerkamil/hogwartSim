package hogwartSim.map.creator;

import hogwartSim.map.IMap;
import hogwartSim.map.MaraudersMap;

/**
 * Class responsible for creating the map
 */
public class MapCreator implements IMapCreator {
     final int mapSize;
     long seed;

    public MapCreator(int mapSize, long seed) {
        this.mapSize = mapSize;
        this.seed = seed;
    }

    public IMap createMap() {
        return new MaraudersMap(mapSize, seed);
    }
}
