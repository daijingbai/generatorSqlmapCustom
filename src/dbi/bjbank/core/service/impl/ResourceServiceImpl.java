package dbi.bjbank.core.service.impl;

import dbi.bjbank.core.bean.Resource;
import dbi.bjbank.core.bean.ResourceExample;
import dbi.bjbank.core.dao.ResourceMapper;
import dbi.bjbank.core.service.ResourceService;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    ResourceMapper resourceMapper;

    public int deleteByPrimaryKey(Long resourceId) throws Exception {
        return resourceMapper.deleteByPrimaryKey(resourceId);
    }

    public int insert(Resource record) throws Exception {
        return resourceMapper.insert(record);
    }

    public Map<String,Object> findByPage(Resource record, int startPage, int endPage) throws Exception {
        Map<String,Object> map=new LinkedHashMap<String,Object>();
        ResourceExample example=new ResourceExample();
        //具体条件查询请自行处理！！！
        map.put("total", resourceMapper.selectByExampleWithPage(example,startPage,endPage));
        map.put("rows", resourceMapper.countByExample(example));
        return map;
    }

    public int updateByPrimaryKeySelective(Resource record) throws Exception {
        return resourceMapper.updateByPrimaryKeySelective(record);
    }
}