package hogwartSim.dumbledore;

public class Dumbledore implements IDumbledore {
    private int[] houses = new int[4];

    /**
     * add points to a house
     */

    @Override
    public void addPoints(String house, int points) {

        switch (house) {
            case "Gryffindor": {
                houses[0] += points;
                break;
            }
            case "Slytherin": {
                houses[1] += points;
                break;
            }
            case "Ravenclaw": {
                houses[2] += points;
                break;
            }
            case "Hufflepuff": {
                houses[3] += points;
                break;
            }
            default:
                throw new IllegalStateException("Unexpected house value in addPoints: " + house);
        }
    }

    /**
     * add 50 points to Gryffindor and check which house has the most points
     */


    public String declareWinner(int[] houses) {
        addPoints("Gryffindor", 50);
        int max = houses[0];
        for (int i = 0; i < 4; i++) {
            if (max <= houses[i]) {
                max = houses[i];
            }
            if (max==houses[0]) {
                System.out.println("Gryffindor wins the House Cup");
            }
            else if (max==houses[1]) {
                System.out.println("Ravenclaw wins the House Cup");
            }
            else if (max==houses[2]) {
                System.out.println("Ravenclaw wins the House Cup");
            }
            else {
                System.out.println("Hufflepuff wins the House Cup");
            }


        return null;
    }
}