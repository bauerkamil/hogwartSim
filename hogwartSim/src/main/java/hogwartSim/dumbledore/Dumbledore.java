package hogwartSim.dumbledore;

import hogwartSim.general.HogwartHouses;
import hogwartSim.general.creator.CreatureCreator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Class to count the points and to declare a winner
 */
public class Dumbledore implements IDumbledore {
    private String filepath = "HouseChart.csv";
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
            System.out.println("Slytherin wins the House Cup");
        } else if (max == housesPoints[2]) {
            System.out.println("Hufflepuff wins the House Cup");
        } else {
            System.out.println("Ravenclaw wins the House Cup");
        }

    }

   public void HousesChart() {

       System.out.println(HogwartHouses.GRYFFINDOR + ": " + housesPoints[0]);
       System.out.println(HogwartHouses.SLYTHERIN + ": " + housesPoints[1]);
       System.out.println(HogwartHouses.HUFFLEPUFF + ": " + housesPoints[2]);
       System.out.println(HogwartHouses.RAVENCLAW + ": " + housesPoints[3]);
       System.out.println("------------------------------------------");



        try {


            FileWriter fileW = new FileWriter(filepath, true);
            BufferedWriter bufferedW = new BufferedWriter(fileW);
            PrintWriter printW = new PrintWriter(bufferedW);

            printW.println(HogwartHouses.GRYFFINDOR+";"+housesPoints[0]);
            printW.println(HogwartHouses.SLYTHERIN+";"+housesPoints[1]);
            printW.println(HogwartHouses.HUFFLEPUFF+";"+housesPoints[2]);
            printW.println(HogwartHouses.RAVENCLAW+";"+housesPoints[3]);
            printW.println(" ");

            printW.flush();
            printW.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
   }
}