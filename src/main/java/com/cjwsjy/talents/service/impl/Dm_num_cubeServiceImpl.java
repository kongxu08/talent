package com.cjwsjy.talents.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjwsjy.talents.dao.Dm_num_cubeMapper;
import com.cjwsjy.talents.entity.Dm_num_cube;
import com.cjwsjy.talents.service.IDm_num_cubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuli2
 * @since 2019-07-15
 */
@Service
public class Dm_num_cubeServiceImpl extends ServiceImpl<Dm_num_cubeMapper, Dm_num_cube> implements IDm_num_cubeService {
    @Resource
    private Dm_num_cubeMapper cubeMapper;
    @Override
    public IPage<Dm_num_cube> highLevevlQuery(IPage page, Wrapper<Dm_num_cube> wrapper) {
        return cubeMapper.highLevevlQuery(page,wrapper);
    }
}
