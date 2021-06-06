package hogwartSim.general.creator;

import hogwartSim.dumbledore.IDumbledore;
import hogwartSim.general.ICreature;
import hogwartSim.general.HogwartHouses;
import hogwartSim.map.IMap;

import java.util.List;

/**
 * Interface for creating creatures
 */
public interface ICreatureCreator {
    List<ICreature> createCreatures(IMap map, IDumbledore dumbledore);
    public HogwartHouses sortingHat(int wizardNumber);
}
