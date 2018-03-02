package customize.annotate.annotate;

import java.lang.annotation.*;

/**
 * 自定义注解.
 *
 * @author: huang
 * Date: 18-3-2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
public @interface AnnotateTest {

    boolean id() default false;

    String name() default "";

    boolean editable() default true;
}
