package com.yngk.usermanage.biz.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yngk.usermanage.biz.GroupBiz;
import com.yngk.usermanage.dao.GroupInfoDao;
import com.yngk.usermanage.dao.RelationInfoDao;
import com.yngk.usermanage.dao.UserExtendRelationInfoDao;
import com.yngk.usermanage.dao.UserInfoDao;
import com.yngk.usermanage.model.GroupInfo;
import com.yngk.usermanage.model.UserInfo;
import com.yngk.utils.biz.BaseBizImpl;
import com.yngk.utils.dao.BaseDao;

/**
 * @ClassName: GroupBizImpl
 */
@Service
public class GroupBizImpl extends BaseBizImpl<GroupInfo> implements GroupBiz, Serializable
{

    private static final long serialVersionUID = 5495581733172941134L;
    @Autowired
    private GroupInfoDao groupInfoDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserExtendRelationInfoDao userExtendRelationInfoDao;
    @Autowired
    private RelationInfoDao relationInfoDao;

    @Override
    public List<GroupInfo> getList()
    {
        return groupInfoDao.selectList();

    }

    @Override
    public List<GroupInfo> getListByParentId(String id)
    {
        return groupInfoDao.selectListByParentId(id);
    }

    @Override
    public boolean addGroup(GroupInfo groupInfo) throws Exception
    {
        boolean flag = false;
        int i = groupInfoDao.insertSelective(groupInfo);
        if (i >= 0)
        {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean deleteGroup(String id) throws Exception
    {
        boolean flag = false;
        int i = groupInfoDao.deleteByPrimaryKey(id);
        if (i >= 0)
        {
            flag = true;
        }
        if (!flag)
        {
            return flag;
        }
        // 级联删除部门关联关系
        Map<String, String> map = new HashMap<String, String>();
        map.put("subId", id);
        relationInfoDao.deleteByDetail(map);
        // 级联删除部门用户
        List<UserInfo> userList = userInfoDao.selectListByGroupId(id);
        for (UserInfo user : userList)
        {
            int j = userInfoDao.deleteByPrimaryKey(user.getId());
            if (j >= 0)
            {
                // 用户相关关联
                userExtendRelationInfoDao.deleteByMianId(user.getId());
                map = new HashMap<String, String>();
                map.put("mainId", user.getId());
                relationInfoDao.deleteByDetail(map);
            }
        }
//        CommonUtil.clearCache();
        return flag;
    }

    @Override
    public boolean editGroup(GroupInfo groupInfo) throws Exception
    {
        boolean flag = false;
        int i = groupInfoDao.updateByPrimaryKeySelective(groupInfo);
        if (i >= 0)
        {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<GroupInfo> getList(String state)
    {
        // TODO Auto-generated method stub
        return groupInfoDao.selectListByState(state);
    }

    @Override
    public GroupInfo getById(String id) throws Exception
    {
        // TODO Auto-generated method stub
        return groupInfoDao.selectByPrimaryKey(id);
    }
    @Override
    public List<GroupInfo> getListByCode(String longCode)
    {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("longCode", longCode);
        return groupInfoDao.selectListByCode(map);
    }
    
    @Override
    public List<GroupInfo> getGroupListByType(String groupType)
    {
        return groupInfoDao.selectListByType(groupType);
    }
    
    @Override
    public List<String> getGroupTypeList()
    {
        List<String> result = groupInfoDao.getGroupTypeList();
        if (null != result)
        {
            return result;
        }
        return new ArrayList<String>();
    }
    
    /**
     * @return the groupInfoDao
     */
    public GroupInfoDao getGroupInfoDao()
    {
        return groupInfoDao;
    }

    /**
     * @param groupInfoDao the groupInfoDao to set
     */
    public void setGroupInfoDao(GroupInfoDao groupInfoDao)
    {
        this.groupInfoDao = groupInfoDao;
    }

    @Override
    public BaseDao<GroupInfo> getDao()
    {
        return groupInfoDao;
    }
	
    public UserInfoDao getUserInfoDao()
    {
        return userInfoDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao)
    {
        this.userInfoDao = userInfoDao;
    }

//    public UserExtendRelationInfoDao getUserExtendRelationInfoDao()
//    {
//        return userExtendRelationInfoDao;
//    }
//
//    public void setUserExtendRelationInfoDao(UserExtendRelationInfoDao userExtendRelationInfoDao)
//    {
//        this.userExtendRelationInfoDao = userExtendRelationInfoDao;
//    }

    public RelationInfoDao getRelationInfoDao()
    {
        return relationInfoDao;
    }

    public void setRelationInfoDao(RelationInfoDao relationInfoDao)
    {
        this.relationInfoDao = relationInfoDao;
    }
}
