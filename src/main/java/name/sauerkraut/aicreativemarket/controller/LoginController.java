package name.sauerkraut.aicreativemarket.controller;

import name.sauerkraut.aicreativemarket.bean.UserBean;
import name.sauerkraut.aicreativemarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }


    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String loginIn(String username, String password) {
        UserBean userBean = userService.loginIn(username, password);
        if(userBean != null) {
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String registerUser(String email, String username, String password1, String password2) {
        if(Objects.equals(email, "") || Objects.equals(username, "") || Objects.equals(password1, "") || Objects.equals(password2, ""))
            return "errorregister";
        if(password1.equals(password2))
        {
            Boolean f =  userService.registerUser(email, username, password1);
            if(f)
                return "successregister";
            else
                return "errorregister";
        }
        return "errorregister";
    }
}
