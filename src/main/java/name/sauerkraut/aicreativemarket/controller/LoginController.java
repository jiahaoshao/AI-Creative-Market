package name.sauerkraut.aicreativemarket.controller;

import name.sauerkraut.aicreativemarket.bean.UserBean;
import name.sauerkraut.aicreativemarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //登录逻辑
    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String loginIn(String email, String password, Model model) {
        UserBean userBean = userService.loginIn(email, password);
        if(userBean != null) {
            return "home";
        }else{
            if(!userService.isexist(email))
            {
                model.addAttribute("email",email);
                model.addAttribute("emailinfo", "该邮箱未注册");
                return "login";
            }
            else{
                model.addAttribute("email",email);
                model.addAttribute("pwdinfo", "密码错误");
                return "login";
            }
        }
    }
}
