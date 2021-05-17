package hogwartSim.map;

import hogwartSim.general.ICreature;
import hogwartSim.general.IItem;

public interface IMap {
    public void changePosition(ICreature creature);
    public ICreature checkPosition(ICreature givenCreature);

    public IItem checkForItemPosition(ICreature student1);
}
