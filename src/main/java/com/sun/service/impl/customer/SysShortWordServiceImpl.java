package com.sun.service.impl.customer;


import com.sun.entity.customer.SysShortWord;
import com.sun.repository.dao.customer.ISysShortWordDAO;
import com.sun.service.customer.ISysShortWordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 微冷的雨
 * @date 2020/5/6 7:56
 */
//快捷语服务层实现类
@Service("sysShortWordService")
public class SysShortWordServiceImpl implements ISysShortWordService {

    //00.注入DAO
    @Resource(name="ISysShortWordDAO")
    private ISysShortWordDAO sysShortWordDAO;

    //01.根据类型查询快捷语
    @Override
    public List<SysShortWord> findShortWordByTid(Integer tid) {
        return sysShortWordDAO.findShortWordByTid(tid);
    }

    //02.根据关键字查询快捷语
    @Override
    public List<SysShortWord> findShortWordByWord(SysShortWord word) {
        return sysShortWordDAO.findShortWordByWord(word);
    }

    //03、添加或更新一条树状短语数据
    @Override
    public int saveShortWord(SysShortWord sysShortWord) throws Exception {
        // 添加操作
        if (null == sysShortWord.getId()) {
            sysShortWordDAO.saveShortWord(sysShortWord);
        } else { // 更新操作
            sysShortWordDAO.updateShortWord(sysShortWord);
        }
        return sysShortWord.getId();
    }

    @Override
    public void deleteShortWord(Integer id) throws Exception {
        sysShortWordDAO.deleteShortWord(id);
    }

    @Override
    public void deleteShortWordByTypeId(Integer id) throws Exception {
        sysShortWordDAO.deleteShortWordByTypeId(id);
    }


}
