package com.cjwsjy.talents.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cjwsjy.talents.entity.Dim_org_orgs2;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuli2
 * @since 2019-08-30
 */
public interface IDim_org_orgs2Service extends IService<Dim_org_orgs2> {
    List<Map> getOrgEmployeeNum();
    List<Map> getEmployeeType(Map map);
    List<Map> getEmployeeTypeForRylb(Map map);
}
