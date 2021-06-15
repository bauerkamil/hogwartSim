package hogwartSim.general;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Enum class to improve working with Houses
 */
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
     * Gets house based on number
     * @param houseValue House number
     * @return Returns the value related to the House
     */
    public static HogwartHouses getNameOfHouse(int houseValue) {
        return (HogwartHouses) houseMap.get(houseValue);
    }

    /**
     * Gets size of enum
     * @return Returns size of enum
     */
    public static int size() {
        return houseMap.size();
    }

    /**
     * Gets number of the House
     * @return Returns the number of the House
     */
    public int getValue() {
        return value;
    }

}
