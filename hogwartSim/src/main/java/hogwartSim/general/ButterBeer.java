package hogwartSim.general;

import hogwartSim.map.IMap;

public class ButterBeer extends Item {
    protected boolean isUsed;

    public ButterBeer(IMap map){
        super(map);
        this.isUsed = true;
    }


}
