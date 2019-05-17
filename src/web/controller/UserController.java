package web.controller;



import web.User;

import web.dao.UserDao;



import java.io.IOException;

import java.util.List;



import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;



import com.alibaba.fastjson.JSONArray;

import com.alibaba.fastjson.JSONObject;



@Controller

@RequestMapping(value="/user")

public class UserController {

	private static Logger log = Logger.getLogger(UserController.class);

    @Autowired

    UserDao userDao;



    @RequestMapping(value="/add.do",method=RequestMethod.POST)

    public void addUser(User user,HttpServletRequest request, HttpServletResponse response) throws IOException{

    	request.setCharacterEncoding("UTF-8");  

    	response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8"); 

        System.out.println(user.getTime()+":"+user.getUserName());

        userDao.add(user);

        response.getWriter().write("Web 服务器说：用户 ["+user.getUserName()+"] 已成功注册并登陆了服务器"); 

    }



    @RequestMapping(value="/findAll.do",method=RequestMethod.POST)

    public void findAll(User u,HttpServletRequest request, HttpServletResponse response) throws IOException{

    	request.setCharacterEncoding("UTF-8");  

    	response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        List<User> list=userDao.findAll(u.getUserName());

        log.info("hell ....");

        JSONArray json=new JSONArray();

        for(User user : list){

            JSONObject jo = new JSONObject();

            jo.put("time", user.getTime());

            jo.put("userName", user.getUserName());

            jo.put("id", user.getId());

            json.add(jo);

        }

        System.out.println("json="+json);

        response.getWriter().write(""+json);

    }

}

