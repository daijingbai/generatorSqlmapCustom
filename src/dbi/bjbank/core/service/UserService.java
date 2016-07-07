package dbi.bjbank.core.service;

import dbi.bjbank.core.bean.User;
import java.util.Map;

public interface UserService {
    int deleteByPrimaryKey(Long userId) throws Exception;

    int insert(User record) throws Exception;

    Map<String,Object> findByPage(User record, int startPage, int endPage) throws Exception;

    int updateByPrimaryKeySelective(User record) throws Exception;
}