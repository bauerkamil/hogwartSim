package hogwartSim.map.creator;

import hogwartSim.map.IMap;
import hogwartSim.map.MarudersMap;

public class MapCreator implements IMapCreator {
     final int mapSize;

    public MapCreator(int mapSize) {
        this.mapSize = mapSize;
    }

    public IMap createMap() {
        return new MarudersMap(mapSize);
    }
}
