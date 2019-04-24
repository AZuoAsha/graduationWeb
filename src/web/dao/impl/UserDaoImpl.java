package web.dao.impl;

import web.User;
import web.dao.UserDao;
import web.redis.RedisClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

    @Autowired
    RedisClient redisClient;
    
    @Override
    public void add(User user) {
    	String statement = "mappers.UserMapper.register";
		getSqlSession().insert(statement, user);
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void update(String name) {

    }

    @Override
    public void find(String name) {

    }

	@Override
	public List<User> findAll() {
		String statement = "mappers.UserMapper.findAll";
		List<User> list=getSqlSession().selectList(statement);
		return list;
	}
}
