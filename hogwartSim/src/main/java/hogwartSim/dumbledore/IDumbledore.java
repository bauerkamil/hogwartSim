package hogwartSim.dumbledore;

import hogwartSim.general.HogwartHouses;

public interface IDumbledore {

    public void addPoints(HogwartHouses house, int points);

    public String declareWinner();

    void HousesChart();
}