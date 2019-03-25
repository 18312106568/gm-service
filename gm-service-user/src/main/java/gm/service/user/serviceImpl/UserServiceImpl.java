package gm.service.user.serviceImpl;



import gm.common.base.annotation.CostLog;
import gm.facade.user.entity.User;
import gm.facade.user.service.UserService;
import gm.service.user.repository.UserRepository;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "${gm.service.user.version}",
        timeout = 30000)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @CostLog
    @Override
    public Long saveUser(String name) {
        long start = System.currentTimeMillis();
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        long end = System.currentTimeMillis();
        long cost = end-start;
        return cost;
    }

    @CostLog
    @Override
    public User getUser(Long id) {
        User user = userRepository.findById(id).get();
        return  user;
    }

    @CostLog
    @Override
    public List<User> listUser(String name) {
        List<User> userList = userRepository.findAllByName(name);
        return userList;
    }
}
