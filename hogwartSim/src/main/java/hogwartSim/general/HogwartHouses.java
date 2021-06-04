package hogwartSim.general;

import java.util.HashMap;
import java.util.Map;

public enum HogwartHouses {
    GRYFFINDOR(0),
    SLYTHERIN(1),
    HUFFLEPUFF(2),
    RAVENCLAW(3);

    private final int value;

    private static Map houseMap = new HashMap();
    private HogwartHouses(int value) {
        this.value = value;
    }

    static {
        for (HogwartHouses hogwartHouses : HogwartHouses.values()) {
            houseMap.put(hogwartHouses.value, hogwartHouses);
        }
    }

    public static HogwartHouses valueOfHouse(int houseValue) {
        return (HogwartHouses) houseMap.get(houseValue);
    }

    public static int size(){return houseMap.size();}

    public int getValue() {
        return value;
    }
}
