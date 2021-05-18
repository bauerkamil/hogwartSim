package hogwartSim.map;

import hogwartSim.general.ICreature;
import hogwartSim.general.IItem;
import hogwartSim.general.Item;

public interface IMap {
    public void changePosition(ICreature creature);
    void changeItemPosition(IItem item);
    public ICreature checkPosition(ICreature givenCreature);
    public IItem checkForItemPosition(ICreature student1);

    public void removeFromMap(ICreature creatureToRemove);
    public void removeItemFromMap(IItem itemToRemove);
}
