package com.cjwsjy.talents.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cjwsjy.talents.entity.Dim_org_orgs2;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuli2
 * @since 2019-08-30
 */
public interface Dim_org_orgs2Mapper extends BaseMapper<Dim_org_orgs2> {
    List<Map> getOrgEmployeeNum();
    List<Map> getEmployeeType(Map map);

}
