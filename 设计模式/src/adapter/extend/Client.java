package adapter.extend;

/**
 * 使用适配器类转换接口
 * <p>
 * User : Dragon_hht
 * Date : 17-3-31
 * Time : 下午7:18
 */
public class Client {
    private Socket socket;

    public void functionTest() {
        socket = new ExpansionAdapter();
        String input = socket.getInput();
        System.out.println(input);
    }

    public static void main(String[] arg) {
        Client client = new Client();
        client.functionTest();
    }
}
