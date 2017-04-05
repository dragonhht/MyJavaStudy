package expression;

/**
 * 构建interPeter树，定义规则
 * <p>
 * User : Dragon_hht
 * Date : 17-4-5
 * Time : 下午8:26
 */
public class InterpreterTest {
    static Expression buildInterpreterTree() {
        Expression terminal1 = new TerminaExpression("Name1");
        Expression terminal2 = new TerminaExpression("Name2");
        Expression terminal3 = new TerminaExpression("Name3");
        Expression terminal4 = new TerminaExpression("Name4");

        //Name2 或 Name3
        Expression alternation1 = new OrExpression(terminal2, terminal3);

        //Name1 或 （Name2 或 Name3）
        Expression alternation2 = new OrExpression(terminal1, alternation1);

        //Name1 和 （Name2 或 （Name3 或 Name4））
        return new AndExpression(terminal4, alternation2);
    }

    public static void main(String[] args) {
        String context = "Name1 Name3";
        Expression define = buildInterpreterTree();
        System.out.println(context + " is " +define.interpret(context));
    }
}
