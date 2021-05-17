package hogwartSim.dumbledore.creator;

public class DumbledoreCreator implements IDumbledore {

@Override
    public createDumbledore() {
        return new Dumbledore();
    }

}
