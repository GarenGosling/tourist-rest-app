package org.garen.tourist.service;

import org.garen.tourist.mybatis.domain.User;
import org.garen.tourist.mybatis.domain.UserExample;
import org.garen.tourist.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/23.
 */
@Service
public class UserManager extends BaseManage<Long>{
    @Autowired
    private UserService<User, UserExample, Long> service;

    @Override
    public UserService<User, UserExample, Long> getService() {
        return service;
    }

}
