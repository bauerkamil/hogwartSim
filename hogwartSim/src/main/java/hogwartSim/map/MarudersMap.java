package hogwartSim.map;

import hogwartSim.general.ICreature;


import java.awt.geom.Point2D;
import java.util.*;

public class MarudersMap {


    protected Random rnd1;
    protected Random rnd2;
    protected long seed=0;
    private final ICreature[] creatures;
    private final Map<ICreature, Point2D> generalPosition;

    public MarudersMap(int mapSize) {
        creatures = new ICreature[mapSize];
        generalPosition=new HashMap<>();
    }

    public void changePosition(ICreature creature) {

        }

}
