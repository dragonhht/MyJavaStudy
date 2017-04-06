package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 菜单类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-6
 * Time : 下午7:28
 */
public class Menu {
    //Item类的条目列表
    List<Item> menuItems;

    public Menu() {
        menuItems = new ArrayList<Item>();
    }

    //增加条目
    public void addItem(Item item) {
        menuItems.add(item);
    }

    public Iterator<Item> CreateIterator() {
        return  new MenuIterator();
    }

    //内部类
    class MenuIterator implements Iterator<Item> {
        int currentIndex = 0;

        //判断是否为最后一个
        public boolean hasNext() {
            if (currentIndex >= menuItems.size()) {
                return false;
            } else {
                return true;
            }
        }

        //获取第一个
        public Item first() {
            return menuItems.get(0);
        }

        //获取当前
        public Item currentItem() {
            return menuItems.get(currentIndex);
        }

        //获取下一个
        public Item next() {
            return menuItems.get(currentIndex++);
        }

        //移除
        public void remove() {
            menuItems.remove(--currentIndex);
        }
    }
}
