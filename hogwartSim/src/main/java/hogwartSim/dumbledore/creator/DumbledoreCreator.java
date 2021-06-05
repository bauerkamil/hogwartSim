package hogwartSim.dumbledore.creator;

import hogwartSim.dumbledore.Dumbledore;
import hogwartSim.dumbledore.IDumbledore;

/**
 * A class to create Dumbledore
 */
public class DumbledoreCreator implements IDumbledoreCreator {
    protected Dumbledore dumbledore;

    /**
     * Creates Dumbledore object
     */
    @Override
    public IDumbledore createDumbledore() {
        if (dumbledore == null) {
            dumbledore = new Dumbledore();
        }
        return dumbledore;
    }
}
