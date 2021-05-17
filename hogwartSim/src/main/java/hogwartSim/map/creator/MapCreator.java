package hogwartSim.map.creator;

import hogwartSim.map.IMap;
import hogwartSim.map.MaraudersMap;

public class MapCreator implements IMapCreator {
     final int mapSize;

    public MapCreator(int mapSize) {
        this.mapSize = mapSize;
    }

    public IMap createMap() {
        return new MaraudersMap(mapSize);
    }
}
