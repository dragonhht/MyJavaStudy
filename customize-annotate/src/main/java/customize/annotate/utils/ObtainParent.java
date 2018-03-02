package customize.annotate.utils;

import customize.annotate.annotate.AnnotateTest;
import customize.annotate.model.AnnotateModel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Description.
 *
 * @author: huang
 * Date: 18-3-2
 */
public class ObtainParent<T> {

    private Class<T> model;

    public ObtainParent() {
        init();
    }

    public List<AnnotateModel> init() {
        List<AnnotateModel> list = new ArrayList<AnnotateModel>();
        model = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        if (this.model !=null) {
            Field[] fields = this.model.getDeclaredFields();

            for (Field f : fields) {
                // 包含自定义注解
                AnnotateTest anno = f.getAnnotation(AnnotateTest.class);
                if (anno !=null) {
                    AnnotateModel annoModel = new AnnotateModel(anno, f);
                    list.add(annoModel);
                }
            }

            Method[] methods = model.getMethods();
            for (Method m : methods) {
                AnnotateTest annotateTest = m.getAnnotation(AnnotateTest.class);
                if (annotateTest != null) {
                    AnnotateModel annotateModel = new AnnotateModel(annotateTest, m.getName(), m.getReturnType());
                    list.add(annotateModel);
                }
            }
        }
        return list;
    }
}
