package com.cjwsjy.talents.service.impl;

import com.cjwsjy.talents.entity.Sm_user;
import com.cjwsjy.talents.dao.Sm_userMapper;
import com.cjwsjy.talents.service.ISm_userService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Blob;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuli2
 * @since 2019-07-22
 */
@Service
public class Sm_userServiceImpl extends ServiceImpl<Sm_userMapper, Sm_user> implements ISm_userService {
    @Resource
    Sm_userMapper mapper;
    @Override
    public Map getPic(Map map) {
        return mapper.getPic(map);
    }
}
