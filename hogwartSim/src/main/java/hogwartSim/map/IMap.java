package hogwartSim.map;

import hogwartSim.general.ICreature;

public interface IMap {
    public void changePosition(ICreature creature);
    public ICreature checkPosition(ICreature givenCreature);
}
