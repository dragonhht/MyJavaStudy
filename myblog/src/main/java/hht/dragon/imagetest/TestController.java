package hht.dragon.imagetest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Describe.
 * User: huang
 * Date: 17-6-12
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String d() {
        return "img";
    }

    @RequestMapping("/image")
    public void s (HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);


        Image vCode = new Image(100,30,5,10);
        session.setAttribute("code", vCode.getCode());
        System.out.println("code:::" + session.getAttribute("code"));
        vCode.write(response.getOutputStream());

    }
}
