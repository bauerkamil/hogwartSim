package hogwartSim.dumbledore.creator;

import hogwartSim.dumbledore.Dumbledore;
import hogwartSim.dumbledore.IDumbledore;

/**
 * Class to create Dumbledore
 */
public class DumbledoreCreator implements IDumbledoreCreator {
    private Dumbledore dumbledore;

    /**
     * Creates Dumbledore object as singleton
     */
    @Override
    public IDumbledore createDumbledore() {
        if (dumbledore == null) {
            dumbledore = new Dumbledore();
        }
        return dumbledore;
    }
}
