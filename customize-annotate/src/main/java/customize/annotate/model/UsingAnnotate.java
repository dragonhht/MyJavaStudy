package customize.annotate.model;

import customize.annotate.annotate.AnnotateTest;
import lombok.Data;

/**
 * 使用注解.
 *
 * @author: huang
 * Date: 18-3-2
 */
@Data
public class UsingAnnotate {

    @AnnotateTest(name = "姓名")
    private String name;
    @AnnotateTest(name = "年龄")
    private int age;
}
