package name.sauerkraut.aicreativemarket.controller;

import name.sauerkraut.aicreativemarket.bean.UserBean;
import name.sauerkraut.aicreativemarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //登录逻辑
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String loginIn(String email, String password) {
        UserBean userBean = userService.loginIn(email, password);
        if(userBean != null) {
            return "success";
        }else{
            return "error";
        }
    }
}
