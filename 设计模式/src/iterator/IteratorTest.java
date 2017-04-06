package iterator;

import java.util.Iterator;

/**
 * 测试类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-6
 * Time : 下午7:38
 */
public class IteratorTest {
    public static void main(String[] args) {
        Item it1 = new Item("Item1", 10f);
        Item it2 = new Item("Item2", 20f);
        Item it3 = new Item("Item3", 30f);

        Menu menu = new Menu();
        menu.addItem(it1);
        menu.addItem(it2);
        menu.addItem(it3);

        System.out.println("Display Menu:");
        Iterator<Item> itemIterator = menu.CreateIterator();

        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            System.out.println(item);
        }

        System.out.println("Removing last item returned");

        itemIterator.remove();

        System.out.println("Display Menu:");
        itemIterator = menu.CreateIterator();

        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            System.out.println(item);
        }
    }
}
