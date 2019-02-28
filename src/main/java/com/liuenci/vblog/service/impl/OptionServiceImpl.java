package com.liuenci.vblog.service.impl;

import com.liuenci.vblog.dao.OptionVoMapper;
import com.liuenci.vblog.model.vo.OptionVo;
import com.liuenci.vblog.model.vo.OptionVoExample;
import com.liuenci.vblog.service.IOptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * options表的service
 * @author liuenci
 */
@Service
public class OptionServiceImpl implements IOptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptionServiceImpl.class);

    @Resource
    private OptionVoMapper optionDao;

    @Override
    public void insertOption(OptionVo optionVo) {
        LOGGER.debug("Enter insertOption method:optionVo={}" ,optionVo);
        optionDao.insertSelective(optionVo);
        LOGGER.debug("Exit insertOption method.");
    }

    @Override
    public void insertOption(String name, String value) {
        LOGGER.debug("Enter insertOption method:name={},value={}",name,value );
        OptionVo optionVo = new OptionVo();
        optionVo.setName(name);
        optionVo.setValue(value);
        if(optionDao.selectByExample(new OptionVoExample()).size()==0){
            optionDao.insertSelective(optionVo);
        }else{
            optionDao.updateByPrimaryKeySelective(optionVo);
        }
        LOGGER.debug("Exit insertOption method.");
    }

    @Override
    public void saveOptions(Map<String, String> options) {
        if (null != options && !options.isEmpty()) {
            options.forEach(this::insertOption);
        }
    }

    @Override
    public List<OptionVo> getOptions(){
        return optionDao.selectByExample(new OptionVoExample());
    }
}
