package name.sauerkraut.aicreativemarket.mapper;

import name.sauerkraut.aicreativemarket.bean.UserBean;

public interface UserMapper {
    UserBean GetInfo(String email, String password);
    UserBean IsExist(String email);
    Boolean SetInfo(String email, String username, String password);
}
