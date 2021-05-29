package hogwartSim.dumbledore.creator;

import hogwartSim.dumbledore.Dumbledore;
import hogwartSim.dumbledore.IDumbledore;


public class DumbledoreCreator implements IDumbledoreCreator {
    protected Dumbledore dumbledore;

//    public DumbledoreCreator() {
//    }

    @Override
    public IDumbledore createDumbledore() {
        if (dumbledore == null) {
            dumbledore = new Dumbledore();
        }
        return dumbledore;
    }
}
