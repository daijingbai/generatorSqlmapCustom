package dbi.bjbank.core.service;

import dbi.bjbank.core.bean.Resource;
import java.util.Map;

public interface ResourceService {
    int deleteByPrimaryKey(Long resourceId) throws Exception;

    int insert(Resource record) throws Exception;

    Map<String,Object> findByPage(Resource record, int startPage, int endPage) throws Exception;

    int updateByPrimaryKeySelective(Resource record) throws Exception;
}