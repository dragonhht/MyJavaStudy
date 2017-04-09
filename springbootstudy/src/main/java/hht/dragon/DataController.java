package hht.dragon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据库的基本操作
 * <p>
 * User : Dragon_hht
 * Date : 17-4-9
 * Time : 下午4:55
 */
@RestController
public class DataController {

    @Autowired
    private DataRepository dataRepository;

    //查找所有
    @RequestMapping("/get")
    public List<DataTest> getData() {
        return dataRepository.findAll();
    }

    //添加
    @RequestMapping("/add")
    public DataTest add() {
        String name = "hj";
        Integer age = 3;
        DataTest dataTest = new DataTest();
        dataTest.setAge(age);
        dataTest.setName(name);

        return dataRepository.save(dataTest);
    }

    //查询一个
    @GetMapping(value = "/getone/{id}")
    public DataTest getone(@PathVariable("id") Integer id) {
        return dataRepository.findOne(id);
    }

    //更新
    @RequestMapping("/update")
    public DataTest updateOne() {
        DataTest dataTest = new DataTest();
        dataTest.setId(3);
        dataTest.setName("张三");
        dataTest.setAge(99);

        return dataRepository.save(dataTest);
    }

    //删除
    @RequestMapping("/del")
    public void del() {
        dataRepository.delete(3);
    }
}
