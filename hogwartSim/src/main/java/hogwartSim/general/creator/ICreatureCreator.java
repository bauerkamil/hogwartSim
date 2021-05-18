package hogwartSim.general.creator;

import hogwartSim.general.ICreature;
import hogwartSim.map.IMap;

import java.util.List;

public interface ICreatureCreator {
    List<ICreature> createCreatures(IMap map);
    public String sortingHat(int wizardNumber);
}
