package hogwartSim.general.creator;

import hogwartSim.general.IItem;
import hogwartSim.map.IMap;

import java.util.List;

/**
 * Interface for creating objects
 */
public interface IItemCreator {
    public List<IItem> createItems(IMap map);
}
