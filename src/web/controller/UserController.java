package web.controller;

import web.User;
import web.dao.UserDao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public void addUser(User user,HttpServletRequest request, HttpServletResponse response) throws IOException{
    	request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8"); 
        System.out.println(user.getTime()+":"+user.getUserName());
        userDao.add(user);
        response.getWriter().write("{\"falg\":\"success\"}"); 
    }

}
