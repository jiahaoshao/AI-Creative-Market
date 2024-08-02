package name.sauerkraut.aicreativemarket.service;

import name.sauerkraut.aicreativemarket.bean.UserBean;

public interface UserService {
    UserBean loginIn(String email, String password);
    Boolean isexist(String email);
    Boolean registerUser(String email, String username, String password);
}
