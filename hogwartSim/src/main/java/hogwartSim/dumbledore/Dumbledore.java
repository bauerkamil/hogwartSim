package hogwartSim.dumbledore;

import hogwartSim.general.HogwartHouses;

/**
 * Class to count the points and to declare a winner
 */
public class Dumbledore implements IDumbledore {
    protected int[] housesPoints = new int[HogwartHouses.size()];
    //TODO: make map from array

    /**
     * Adds points to the right House
     * @param house The House that gets the points
     * @param points A number of points to add
     */
    @Override
    public void addPoints(HogwartHouses house, int points) {
        housesPoints[house.getValue()]+=points;
    }


    /**
     * Adds 50 points to Gryffindor and checks which house has the most points
     */
    public void declareWinner() {
        addPoints(HogwartHouses.GRYFFINDOR, 50);
        int max = housesPoints[0];
        for (int i = 0; i < 4; i++) {
            if (max < housesPoints[i]) {
                max = housesPoints[i];
            }
        }
        if (max == housesPoints[0]) {
            System.out.println("Gryffindor wins the House Cup");
        } else if (max == housesPoints[1]) {
            System.out.println("Ravenclaw wins the House Cup");
        } else if (max == housesPoints[2]) {
            System.out.println("Ravenclaw wins the House Cup");
        } else {
            System.out.println("Hufflepuff wins the House Cup");
        }

    }
}