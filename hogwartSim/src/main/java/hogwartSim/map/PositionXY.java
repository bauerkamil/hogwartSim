package hogwartSim.map;

/**
 * This class is a wrapper for generating 2 dimensions in map
 */
public class PositionXY {

    public int x;
    public int y;

    public PositionXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Override equals method to check if given object is type of PositionXY and if their parameters x and y are equal
     * @param o given object
     * @return
     */
    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof PositionXY)) {
            return false;
        }

        PositionXY p = (PositionXY) o;

        return x == p.x && y == p.y;
    }

}
