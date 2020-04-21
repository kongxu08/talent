package com.cjwsjy.talents.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cjwsjy.talents.entity.Dim_org_orgs2;
import com.cjwsjy.talents.dao.Dim_org_orgs2Mapper;
import com.cjwsjy.talents.service.IDim_org_orgs2Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuli2
 * @since 2019-08-30
 */
@Service
public class Dim_org_orgs2ServiceImpl extends ServiceImpl<Dim_org_orgs2Mapper, Dim_org_orgs2> implements IDim_org_orgs2Service {
    @Resource
    private Dim_org_orgs2Mapper mapper;
    @Override
    public List<Map> getOrgEmployeeNum(){
        return mapper.getOrgEmployeeNum();
    }
    @Override
    public List<Map> getEmployeeType(Map map){
        return mapper.getEmployeeType(map);
    }
}
