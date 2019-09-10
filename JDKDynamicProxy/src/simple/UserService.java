package simple;

/**
 * 服务接口.
 *
 * @author: huang
 * Date: 18-1-17
 */
public interface UserService {

    String getName(int id);

    String getRoom(int id);

    int getAge(int id);

    void noReturnAndParam();

}
