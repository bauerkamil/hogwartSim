package hogwartSim.dumbledore;

import hogwartSim.general.HogwartHouses;

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
        for(int i = 0; i < housesPoints.length; i++){
            if (max < housesPoints[i]) {
                max = housesPoints[i];
            }
        }

        for(int j = 0; j < housesPoints.length; j++){
            if (max == housesPoints[j]){
                System.out.println(HogwartHouses.valueOfHouse(j) + " wins the House Cup");
            }
        }

        System.out.println("Total number of points:");
        HousesChart();

    }

   public void HousesChart() {

       for(int i = 0; i < housesPoints.length; i++){
           System.out.println(HogwartHouses.valueOfHouse(i) + ": " + housesPoints[i]);
       }

       System.out.println("------------------------------------------");


        try {


            FileWriter fileW = new FileWriter(filepath, true);
            BufferedWriter bufferedW = new BufferedWriter(fileW);
            PrintWriter printW = new PrintWriter(bufferedW);

            for(int i = 0; i < housesPoints.length; i++){
                printW.print(HogwartHouses.valueOfHouse(i) + ";" + housesPoints[i] + ";");
            }

            printW.println(" ");

            printW.flush();
            printW.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
   }
}