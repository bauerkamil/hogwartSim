package hogwartSim.dumbledore;

import hogwartSim.general.HogwartHouses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DumbledoreTest {

    @Test
    void addPoints() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        //when
        dumbledore.addPoints(HogwartHouses.GRYFFINDOR, 50);
        //then
        Assertions.assertEquals(50, dumbledore.housesPoints[HogwartHouses.GRYFFINDOR.getValue()]);
    }

    @Test
    void declareWinnerWhenSlytherinHasTheMostPoints() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        dumbledore.housesPoints = new int[]{0, 100, 0, 0};
        //then
        Assertions.assertEquals( dumbledore.declareWinner(), HogwartHouses.SLYTHERIN + " wins the House Cup \r\n" + "Total number of points:");

    }
//    @Test
//    void declareWinnerToTheFirstInListIfMultipleHousesHaveTheSamePoints() {
//        //given
//        Dumbledore dumbledore = new Dumbledore();
//        dumbledore.housesPoints = new int[]{50, 100, 0, 100}; //Dumbledore adds 50 points to Gryffindor when declaring the Winner
//        //then
//        Assertions.assertEquals( dumbledore.declareWinner(), "Gryffindor");
//
//    }
//    @Test
//    void declareWinnerWhenNumbersAreNegative() {
//        //given
//        Dumbledore dumbledore = new Dumbledore();
//        dumbledore.housesPoints = new int[]{-100,-100, -10, -200};
//        //then
//        Assertions.assertEquals( dumbledore.declareWinner(), "Hufflepuff");
//
//    }
}