package hogwartSim.map;

import hogwartSim.general.ICreature;
import hogwartSim.general.IItem;
import hogwartSim.general.Item;

import java.util.List;

public interface IMap {
    public List<ICreature> getCreatures();
    public void randomLocate(ICreature creature);
    public void randomRelocate(ICreature creature);
    public void randomLocate(IItem item);
    public List<ICreature> getAtPosition(PositionXY positionXY);
    public List<IItem> getItemsAtPosition(PositionXY positionXY);
    public PositionXY getPosition(ICreature creature);
//    public IItem checkForItemPosition(ICreature student1);

    public void removeFromMap(ICreature creatureToRemove);
    public void removeFromMap(IItem itemToRemove);
}
