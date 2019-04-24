package web.controller;

import web.User;
import web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value="/add.do",method=RequestMethod.POST)
    public int addUser(User user){
        System.out.println(user.getTime()+":"+user.getUserName());
        userDao.add(user);
		return 1;
    }

}
