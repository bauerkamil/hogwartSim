package hogwartSim.map.creator;

import hogwartSim.map.IMap;
import hogwartSim.map.MarudersMap;

public class MapCreator implements IMapCreator {
    int mapSize;

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public IMap createMap(int mapSize) {
        return (IMap) new MarudersMap(mapSize);
    }
}
