package customize.annotate.model;

import customize.annotate.annotate.AnnotateTest;
import lombok.Data;

import java.lang.reflect.Field;

/**
 * 获取注解的帮助类.
 *
 * @author: huang
 * Date: 18-3-2
 */
@Data
public class AnnotateModel {

    private AnnotateTest anno;
    private Field field;
    private String name;
    private Class<?> type;

    public AnnotateModel() {

    }

    public AnnotateModel(AnnotateTest anno, Field field) {
        this.anno = anno;
        this.field = field;
        this.name = field.getName();
        this.type = field.getType();
    }

    public AnnotateModel(AnnotateTest anno, String name, Class<?> type) {
        this.anno = anno;
        this.name = name;
        this.type = type;
    }

}
