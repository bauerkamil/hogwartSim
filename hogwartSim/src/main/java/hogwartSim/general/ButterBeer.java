package hogwartSim.general;

import hogwartSim.map.IMap;

public class ButterBeer extends Item {
    protected boolean isUsed;

    public ButterBeer(IMap map){
        super(map);
        this.isUsed = true;
    }
    @Override
    public void getUsed() {
        this.isUsed = false;
        System.out.println("Student drunk. Student happy. Student finds point record and add themselves some points");

    }

}
