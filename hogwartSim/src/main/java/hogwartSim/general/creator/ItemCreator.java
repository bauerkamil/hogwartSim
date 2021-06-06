package hogwartSim.general.creator;

import hogwartSim.general.ButterBeer;
import hogwartSim.general.IItem;
import hogwartSim.map.IMap;

import java.util.LinkedList;
import java.util.List;

/**
 * Class to create butterbeers
 */
public class ItemCreator implements IItemCreator {

    protected int numBeers;

    /**
     * Creates butterbeers to place on the map
     * @param numBeers The number of butterbeers to create
     */
    public ItemCreator(int numBeers){this.numBeers=numBeers;}
    @Override
    public List<IItem> createItems(IMap map) {
        List<IItem> itemList = new LinkedList<>();
        for (int i=0; i<numBeers; i++){
            itemList.add(new ButterBeer(map));
        }
        return itemList;
    }
}
