package gm.service.fee.serviceImpl;

import org.apache.dubbo.config.annotation.Reference;
import gm.facade.fee.service.FeeService;
import gm.facade.user.entity.User;
import gm.facade.user.service.UserService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "${gm.service.fee.version}",
        timeout = 30000)
public class FeeServiceImpl implements FeeService {

    @Reference(version = "1.0.0")
    UserService userService;

    @Override
    public Integer countUser(String userName) {
        List<User> userList = userService.listUser(userName);
        System.out.println(userList);
        return userList.size();
    }
}
