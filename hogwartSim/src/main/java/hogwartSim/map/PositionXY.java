package hogwartSim.map;

public class PositionXY {
    /**
     * this class is a wrapper for generating 2 dimensions in map
     */
    public int x;
    public int y;

    public PositionXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
