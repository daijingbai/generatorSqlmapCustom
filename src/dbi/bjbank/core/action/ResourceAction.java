package dbi.bjbank.core.action;

import dbi.bjbank.core.bean.Resource;
import dbi.bjbank.core.service.ResourceService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/Resource")
public class ResourceAction {
    @Autowired
    ResourceService resourceServiceImpl;

    @RequestMapping(value="/delete.do")
    public void delete(Long resourceId) throws Exception {
        resourceServiceImpl.deleteByPrimaryKey(resourceId);
    }

    @RequestMapping(value="/insert.do")
    public void insert(Resource record) throws Exception {
        resourceServiceImpl.insert(record);
    }

    @RequestMapping(value="/findByPage.do")
    @ResponseBody
    public Map<String,Object> findByPage(Resource record, int rows, int page) throws Exception {
        int startPage=rows*(page-1)+1;
        int endPage=rows*page;
        return resourceServiceImpl.findByPage(record,startPage,endPage);
    }

    @RequestMapping(value="/update.do")
    public void update(Resource record) throws Exception {
        resourceServiceImpl.updateByPrimaryKeySelective(record);
    }
}