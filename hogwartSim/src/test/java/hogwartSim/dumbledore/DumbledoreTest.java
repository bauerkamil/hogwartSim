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
    void declareWinner_WhenSlytherinHasTheMostPoints() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        dumbledore.housesPoints = new int[]{0, 100, 0, 0};
        //then
        Assertions.assertEquals( dumbledore.declareWinner(), HogwartHouses.SLYTHERIN);

    }
    @Test
    void declareWinner_IfTwoHousesHaveTheSamePoints_TheSecondOneWins() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        dumbledore.housesPoints = new int[]{0, 100, 0, 100}; //Slytherin and Ravenclaw have the same amount of points
        //then
        Assertions.assertEquals( dumbledore.declareWinner(), HogwartHouses.RAVENCLAW);

    }
    @Test
    void declareWinner_IfThreeHousesHaveTheSamePoints_TheSecondOneWins() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        dumbledore.housesPoints = new int[]{0, 100, 100, 100}; //Slytherin, Hufflepuff and Ravenclaw have the same amount of points
        //then
        Assertions.assertEquals( dumbledore.declareWinner(), HogwartHouses.HUFFLEPUFF);

    }
    @Test
    void declareWinnerWhenNumbersAreNegative() {
        //given
        Dumbledore dumbledore = new Dumbledore();
        dumbledore.housesPoints = new int[]{-100,-100, -10, -200};
        //then
        Assertions.assertEquals( dumbledore.declareWinner(), HogwartHouses.HUFFLEPUFF);

    }
}