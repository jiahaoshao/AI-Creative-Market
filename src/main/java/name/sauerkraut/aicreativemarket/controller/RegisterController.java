package name.sauerkraut.aicreativemarket.controller;

import jakarta.servlet.http.HttpSession;
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
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    //注册逻辑
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String registerUser(String email, String username, String password1, String password2, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("username", username);
        model.addAttribute("password1", password1);
        model.addAttribute("password2", password2);

        if(Objects.equals(email,""))
        {
            model.addAttribute("registerinfo", "邮箱不能为空");
            return "register";
        }
        if(Objects.equals(username,""))
        {
            model.addAttribute("registerinfo", "用户名不能为空");
            return "register";
        }
        if(Objects.equals(password1, ""))
        {
            model.addAttribute("registerinfo", "密码不能为空");
            return "register";
        }
        if(Objects.equals(password2, ""))
        {
            model.addAttribute("registerinfo", "请确认密码");
            return "register";
        }

        if(password1.equals(password2))
        {
            Boolean f =  userService.registerUser(email, username, password1);
            if(f)
            {
                model.addAttribute("registerinfo", "注册成功");
                return "register";
            }
            else
            {
                model.addAttribute("registerinfo", "该邮箱已注册");
                return "register";
            }
        }
        else
        {
            model.addAttribute("registerinfo", "两次输入的密码不一样");
            return "register";
        }
    }

}
