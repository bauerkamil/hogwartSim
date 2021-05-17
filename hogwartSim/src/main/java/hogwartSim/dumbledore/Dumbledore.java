package hogwartSim.dumbledore;

public class Dumbledore implements IDumbledore {
    private int[] houses = new int[4];

    public void addPoints(String house, int points) {
        this.house = house;
        this.points = points;
        switch (house) {
            case "Gryffindor" {
                houses[0] += points;
                break;
            }
            case "Slytherin" {
                houses[1] += points;
                break;
            }
            case "Ravenclaw" {
                houses[2] += points;
                break;
            }
            case "Hufflepuff" {
                houses[3] += points;
                break;
            }
        }
    }


    public void declareWinner(int[] houses) {
        addPoints(String Gryffindor, int 50);
        int max = houses[0];
        for (int i = 0; i < 4; i++) {
            if (max <= houses[i]) {
                max = houses[i]
            }
            switch (max) {
                case houses[0]: {
                    System.out.println("Puchar zdobywa Gryffindor");
                    break;
                }
                case houses[0]: {
                    System.out.println("Puchar zdobywa Slytherin");
                    break;
                }
                case houses[0]: {
                    System.out.println("Puchar zdobywa Ravenclaw");
                    break;
                }
                case houses[0]: {
                    System.out.println("Puchar zdobywa Hufflepuff");
                    break;
                }
            }
        }

    }
}