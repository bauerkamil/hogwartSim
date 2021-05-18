package hogwartSim.dumbledore.creator;

import hogwartSim.dumbledore.Dumbledore;
import hogwartSim.dumbledore.IDumbledore;


public class DumbledoreCreator implements IDumbledoreCreator {


    public DumbledoreCreator() {

    }

    @Override
    public IDumbledore createDumbledore() {
        return new Dumbledore();
    }
}
