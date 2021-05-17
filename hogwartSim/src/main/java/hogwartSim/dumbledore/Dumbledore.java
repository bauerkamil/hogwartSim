package hogwartSim.dumbledore;

public class Dumbledore implements IDumbledore {
    private int[] houses = new int[4];

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


    public String declareWinner(int[] houses) {
        addPoints("Gryffindor", 50);
        int max = houses[0];
        for (int i = 0; i < 4; i++) {
            if (max <= houses[i]) {
                max = houses[i];
            }
        }
            switch (max) {
                case houses[0]: {
                    System.out.println("Puchar zdobywa Gryffindor");
                    break;
                }
                case houses[1]: {
                    System.out.println("Puchar zdobywa Slytherin");
                    break;
                }
                case houses[2]: {
                    System.out.println("Puchar zdobywa Ravenclaw");
                    break;
                }
                case houses[3]: {
                    System.out.println("Puchar zdobywa Hufflepuff");
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + max);
            }


        return null;
    }
}