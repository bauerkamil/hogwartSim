package hogwartSim.general.creator;


import hogwartSim.map.MaraudersMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ItemCreatorTest {

    @Test
    void createItems() {
        //given
        MaraudersMap map = new MaraudersMap(3,1);
        ItemCreator itemCreator = new ItemCreator(5);
        //when
        itemCreator.createItems(map);
        //then
        Assertions.assertEquals( itemCreator.createItems(map).size(), 5);
    }
}