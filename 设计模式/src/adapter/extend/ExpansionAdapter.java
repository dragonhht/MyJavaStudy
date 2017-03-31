package adapter.extend;

/**
 * 具体适配器
 * 适配器类
 * <p>
 * User : Dragon_hht
 * Date : 17-3-31
 * Time : 下午7:13
 */
public class ExpansionAdapter extends ThrePlug implements Socket{
    @Override
    public String getInput() {
        //调用基类的getInput
        String input = super.getInput();
        input = input + "power converted to 2-Pin";
        return input;
    }
}
