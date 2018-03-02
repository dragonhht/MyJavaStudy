
package customize.annotate;

import customize.annotate.model.AnnotateModel;
import customize.annotate.utils.ObtainAnnotate;
import customize.annotate.utils.ObtainParent;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ) {
        ObtainParent anno = new ObtainAnnotate();

        List<AnnotateModel> list = anno.init();

        for(AnnotateModel l : list){
            System.out.println("字段名称："+l.getName()+"\t字段类型："+l.getType()+
                    "\t姓名："+l.getAnno().name()+"\tid："+l.getAnno().id());
        }
    }
}
