package dbi.bjbank.core.service.impl;

import dbi.bjbank.core.bean.User;
import dbi.bjbank.core.bean.UserExample;
import dbi.bjbank.core.dao.UserMapper;
import dbi.bjbank.core.service.UserService;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    public int deleteByPrimaryKey(Long userId) throws Exception {
        return userMapper.deleteByPrimaryKey(userId);
    }

    public int insert(User record) throws Exception {
        return userMapper.insert(record);
    }

    public Map<String,Object> findByPage(User record, int startPage, int endPage) throws Exception {
        Map<String,Object> map=new LinkedHashMap<String,Object>();
        UserExample example=new UserExample();
        //具体条件查询请自行处理！！！
        map.put("total", userMapper.selectByExampleWithPage(example,startPage,endPage));
        map.put("rows", userMapper.countByExample(example));
        return map;
    }

    public int updateByPrimaryKeySelective(User record) throws Exception {
        return userMapper.updateByPrimaryKeySelective(record);
    }
}