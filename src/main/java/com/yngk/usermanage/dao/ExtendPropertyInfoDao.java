package com.yngk.usermanage.dao;

import java.util.List;

import com.yngk.usermanage.model.ExtendPropertyInfo;
import com.yngk.utils.dao.BaseDao;

/**
 * @ClassName: ExtendPropertyInfoMapper
 */
public interface ExtendPropertyInfoDao extends BaseDao<ExtendPropertyInfo>
{

    /**
     * 获取所有扩展属性
     * @Title: selectAll
     * @Description: TODO
     * @return: List<ExtendPropertyInfo>
     */
    List<ExtendPropertyInfo> selectAll();

    /**
     * 根据状态查询扩展属性列表
     * @Title: getListBySate
     * @Description: TODO
     * @return: List<ExtendPropertyInfo>
     */
    List<ExtendPropertyInfo> selectListBySate(String sate);
}