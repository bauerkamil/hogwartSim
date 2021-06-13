package hogwartSim.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    /**
     * gets house based on number
     * @param houseValue house number
     * @return
     */
    public static HogwartHouses getNameOfHouse(int houseValue) {
        return (HogwartHouses) houseMap.get(houseValue);
    }

    /**
     * gets size of enum
     * @return
     */
    public static int size() {
        return houseMap.size();
    }

    /**
     * gets number of a house
     * @return
     */
    public int getValue() {
        return value;
    }

}
