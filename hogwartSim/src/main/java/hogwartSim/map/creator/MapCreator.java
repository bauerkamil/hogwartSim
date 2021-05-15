package hogwartSim.map.creator;

import hogwartSim.map.IMap;
import hogwartSim.map.MarudersMap;

public class MapCreator implements IMapCreator {

    int mapSize =10;
    public MapCreator(int mapSize) {
        this.mapSize=mapSize;
    }

    @Override
    public IMap createMap(int mapSize) {
        return (IMap) new MarudersMap(mapSize);
    }
}
