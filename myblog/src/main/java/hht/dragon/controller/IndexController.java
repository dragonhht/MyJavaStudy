package hht.dragon.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-4-12
 * Time : 下午8:47
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}
