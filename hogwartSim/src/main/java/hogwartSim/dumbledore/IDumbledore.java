package hogwartSim.dumbledore;

/**
 * Interface to count points and to declare a winner
 */
public interface IDumbledore {

    public void addPoints(String house, int points);

    public void declareWinner();
}