package hogwartSim.general.creator;

import hogwartSim.general.ICreature;
import hogwartSim.map.IMap;

import java.util.List;

public interface IGeneralCreator {
    List<ICreature> createCreatures();
}
