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
    private int pointsForTie = 20;
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
     * Adds 50 points to Gryffindor and declare which house has the most points
     */
    public String declareWinner() {
        addPoints(HogwartHouses.GRYFFINDOR, 50);

        int max = housesPoints[0];
        HogwartHouses winningHouse = HogwartHouses.getNameOfHouse(0);

        for(int i = 0; i < housesPoints.length; i++){
            if (max < housesPoints[i]) {
                max = housesPoints[i];
                winningHouse = HogwartHouses.getNameOfHouse(i);
            }

        }

        for (int i = 0; i < housesPoints.length; i++) {

            if (max == housesPoints[i] && i != winningHouse.getValue()) {
                housesPoints[i] += pointsForTie;
                max += pointsForTie;
                System.out.println("Dumbledore really wants house " + HogwartHouses.getNameOfHouse(i) + " to win, so he added them " + pointsForTie + " points.");
                winningHouse = HogwartHouses.getNameOfHouse(i);
            }
        }

        return winningHouse + " wins the House Cup \r\n" + "Total number of points:";



        //return "Total number of points:";
        //HousesChart();

    }

    /**
     * prints data in console and saves it in csv
     */
    public void HousesChart() {

       for(int i = 0; i < housesPoints.length; i++){
           System.out.println(HogwartHouses.getNameOfHouse(i) + ": " + housesPoints[i]);
       }

       System.out.println("------------------------------------------");


        try {


            FileWriter fileW = new FileWriter(filepath, true);
            BufferedWriter bufferedW = new BufferedWriter(fileW);
            PrintWriter printW = new PrintWriter(bufferedW);

            for(int i = 0; i < housesPoints.length; i++){
                printW.print(HogwartHouses.getNameOfHouse(i) + ";" + housesPoints[i] + ";");
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