package adapter.relation;


/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-3-31
 * Time : 下午7:43
 */
public class ExpansionAdapter implements Socket{
    //ThrePlug类现在是适配器的一部分
    private ThrePlug threPlug;

    public ExpansionAdapter(ThrePlug plug) {
        threPlug = plug;
    }

    @Override
    public String getInput() {
       String input = threPlug.getInput();
       input = input + "power converted to 2-Pin";
        return input;
    }
}
