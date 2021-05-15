package hogwartSim.map;

import hogwartSim.general.ICreature;


import java.util.*;

public class MarudersMap {


    protected Random rnd1;
    protected Random rnd2;
    protected long seed=0;
    private ICreature[] creatures;
    private Map<ICreature, Integer> generalPosition;

    public MarudersMap(int mapSize) {
        creatures = new ICreature[mapSize];
        generalPosition=new HashMap<>();
    }

    public void changePosition(ICreature creature) {

        }

}
