package name.sauerkraut.aicreativemarket.controller;

import name.sauerkraut.aicreativemarket.bean.UserBean;
import name.sauerkraut.aicreativemarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FindPasswordController {

    @RequestMapping("/findpwd")
    public String findPassword(Model model) {
        return "findpwd";
    }
}
