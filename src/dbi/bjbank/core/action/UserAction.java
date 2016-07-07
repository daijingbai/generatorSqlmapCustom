package dbi.bjbank.core.action;

import dbi.bjbank.core.bean.User;
import dbi.bjbank.core.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/User")
public class UserAction {
    @Autowired
    UserService userServiceImpl;

    @RequestMapping(value="/delete.do")
    public void delete(Long userId) throws Exception {
        userServiceImpl.deleteByPrimaryKey(userId);
    }

    @RequestMapping(value="/insert.do")
    public void insert(User record) throws Exception {
        userServiceImpl.insert(record);
    }

    @RequestMapping(value="/findByPage.do")
    @ResponseBody
    public Map<String,Object> findByPage(User record, int rows, int page) throws Exception {
        int startPage=rows*(page-1)+1;
        int endPage=rows*page;
        return userServiceImpl.findByPage(record,startPage,endPage);
    }

    @RequestMapping(value="/update.do")
    public void update(User record) throws Exception {
        userServiceImpl.updateByPrimaryKeySelective(record);
    }
}