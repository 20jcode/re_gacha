package re_gacha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import re_gacha.mainlogic.Item;

public class ItemTest {
    Item item = new Item();

    @Test //정상적으로 아이템이 추가되는가?
    void AddItemTest(){
        String itemname = "블랙티켓";

        item.AddItem(itemname);

        assertNotNull(item,"not null");

    }
}
