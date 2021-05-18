package hogwartSim.general.creator;

import hogwartSim.general.IItem;
import hogwartSim.map.IMap;

import java.util.List;

public interface IItemCreator {
    public List<IItem> createItems(IMap map);
}
