package iterator;

/**
 * 菜单上的条目
 * <p>
 * User : Dragon_hht
 * Date : 17-4-6
 * Time : 下午7:26
 */
public class Item {
    String itemName;
    float itemPrice;

    public Item(String itemName, float itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
