package expression;

import java.util.StringTokenizer;

/**
 * 终结符表达式类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-5
 * Time : 下午8:16
 */
public class TerminaExpression extends Expression {

    private String literal = null;
    public TerminaExpression(String str) {
        literal = str;
    }

    @Override
    public boolean interpret(String str) {
        StringTokenizer st = new StringTokenizer(str);

        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(literal)) {
                return true;
            }
        }
        return false;
    }
}
