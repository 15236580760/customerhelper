package com.sun.service.impl.calculator;

import com.sun.entity.calculator.Dictionary;
import com.sun.repository.dao.calculator.IDictionaryDAO;
import com.sun.service.calculator.IDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 微冷的雨
 * @date 2020/5/12 10:11
 */
@Service("dictionaryService")
public class DictionaryServiceImpl implements IDictionaryService {
    //01.注入DAO
    @Resource(name = "IDictionaryDAO")
    private IDictionaryDAO dictionaryDAO;
    @Override
    public List<Dictionary> findAll() {
        return dictionaryDAO.findAll();
    }

    @Override
    public boolean addDicData(Dictionary info) {
        return false;
    }

    @Override
    public boolean updateDicDate(String[] names) {
        return false;
    }

    @Override
    public boolean delDicDataById(Integer id) {
        return false;
    }
}
