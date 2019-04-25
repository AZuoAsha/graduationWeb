package web.controller;

import web.User;
import web.dao.UserDao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
        response.getWriter().write("Web Server Say:Register Success "); 
    }

    @RequestMapping(value="/findAll.do",method=RequestMethod.POST)
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");
        List<User> list=userDao.findAll();
        JSONArray json=new JSONArray();
        for(User user : list){
            JSONObject jo = new JSONObject();
            jo.put("time", user.getTime());
            jo.put("userName", user.getUserName());
            json.add(jo);
        }
        System.out.println("json="+json);
        response.getWriter().write(""+json);
    }
}
