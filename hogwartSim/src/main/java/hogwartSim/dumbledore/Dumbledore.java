package hogwartSim.dumbledore;

import hogwartSim.general.HogwartHouses;

public class Dumbledore implements IDumbledore {
    protected int[] housesPoints = new int[HogwartHouses.size()];

    /**
     * Adds points to a House
     * @param house The House that gets the points
     * @param points A number of points to add
     */
    @Override
    public void addPoints(String house, int points) {

        switch (house) {
            case "Gryffindor": {
                housesPoints[0] += points;
                break;
            }
            case "Slytherin": {
                housesPoints[1] += points;
                break;
            }
            case "Ravenclaw": {
                housesPoints[2] += points;
                break;
            }
            case "Hufflepuff": {
                housesPoints[3] += points;
                break;
            }
            default:
                throw new IllegalStateException("Unexpected house value in addPoints: " + house);
        }
    }


    /**
     * Adds 50 points to Gryffindor and checks which house has the most points
     */
    public void declareWinner() {
        addPoints("Gryffindor", 50);
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