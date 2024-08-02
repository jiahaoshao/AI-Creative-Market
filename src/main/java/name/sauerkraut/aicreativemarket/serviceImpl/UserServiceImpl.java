package name.sauerkraut.aicreativemarket.serviceImpl;

import name.sauerkraut.aicreativemarket.bean.UserBean;
import name.sauerkraut.aicreativemarket.mapper.UserMapper;
import name.sauerkraut.aicreativemarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //登录
    @Override
    public UserBean loginIn(String username, String password) {
        return userMapper.GetInfo(username, password);
    }

    //检查该邮箱是否存在
    @Override
    public Boolean isexist(String email) {
        return userMapper.IsExist(email) != null;
    }

    //注册用户
    @Override
    public Boolean registerUser(String email, String username, String password) {
        if(!isexist(email)) {
            userMapper.SetInfo(email, username, password);
            return true;
        }
        return false;
    }
}
