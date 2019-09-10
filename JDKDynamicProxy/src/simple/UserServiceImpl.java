package simple;

/**
 * Description.
 *
 * @author: huang
 * Date: 18-1-17
 */
public class UserServiceImpl implements UserService {
    @Override
    public String getName(int id) {
        System.out.println(id + ", 张三");
        return null;
    }

    @Override
    public String getRoom(int id) {
        System.out.println(id + ", 寝室号");
        return null;
    }

    @Override
    public int getAge(int id) {
        System.out.println(18);
        return 0;
    }

    @Override
    public void noReturnAndParam() {
        System.out.println("noReturnAndParam...");
    }
}
