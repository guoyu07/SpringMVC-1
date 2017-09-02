package com.yngk.usermanage.biz.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yngk.usermanage.biz.RoleBiz;
import com.yngk.usermanage.dao.RelationInfoDao;
import com.yngk.usermanage.dao.RoleInfoDao;
import com.yngk.usermanage.model.RoleInfo;
import com.yngk.usermanage.util.CommonUtil;
import com.yngk.utils.biz.BaseBizImpl;
import com.yngk.utils.dao.BaseDao;

/** 
 * @ClassName: RoleBizImpl
 */

public class RoleBizImpl extends BaseBizImpl<RoleInfo> implements RoleBiz, Serializable
{

    private static final long serialVersionUID = -7746763686496641164L;
    private RoleInfoDao roleInfoDao;
    private RelationInfoDao relationInfoDao;

    @Override
    public List<RoleInfo> getListByUserId(String userid)
    {
        return roleInfoDao.selectListByUserId(userid);
    }

    @Override
    public List<RoleInfo> getListByState(String state)
    {
        return roleInfoDao.selectListByState(state);
    }

    public RoleInfo getRoleByRoleId(String roleId) throws Exception
    {
        return roleInfoDao.selectByPrimaryKey(roleId);
    }

    public List<RoleInfo> selectListByType(String type, boolean tag)
    {
        List<RoleInfo> roleList = roleInfoDao.selectListByType(type);
        // 如果tag为true，则不走过滤流程
        if (tag)
        {
            return roleList;
        }
        
        List<RoleInfo> result = new ArrayList<RoleInfo>();
        
        if (roleList == null)
        {
            return result;
        }
        
        for (RoleInfo roleInfo : roleList)
        {
            if (CommonUtil.STATE_DISABLE.equals(roleInfo.getDataState()))
            {
                continue;
            }
            result.add(roleInfo);
        }
        return result;
    }

    public boolean deleteByID(String roleId) throws Exception
    {
        boolean flag = false;
        int i = roleInfoDao.deleteByPrimaryKey(roleId);
        if (i >= 0)
        {
            flag = true;
        }
        // 级联删除角色页面关联关系
        Map<String, String> map = new HashMap<String, String>();
        map.put("mainId", roleId);
        map.put("type", CommonUtil.RELATION_ROLE_PAGE);
        relationInfoDao.deleteByDetail(map);
        // 级联删除角色用户关联关系
        Map<String, String> roleUserMap = new HashMap<String, String>();
        roleUserMap.put("subId", roleId);
        roleUserMap.put("type", CommonUtil.RELATION_USER_ROLE);
        relationInfoDao.deleteByDetail(roleUserMap);
        // 级联删除岗位用户关联关系
        Map<String, String> postUserMap = new HashMap<String, String>();
        postUserMap.put("subId", roleId);
        postUserMap.put("type", CommonUtil.RELATION_USER_POST);
        relationInfoDao.deleteByDetail(postUserMap);
        // 级联删除角色功能关联关系
        Map<String, String> roleFuncMap = new HashMap<String, String>();
        roleFuncMap.put("subId", roleId);
        roleFuncMap.put("type", CommonUtil.RELATION_ROLE_FUNC);
        relationInfoDao.deleteByDetail(roleFuncMap);
//        CommonUtil.clearCache();
        return flag;
    }

    public boolean updateRole(RoleInfo info) throws Exception
    {
        boolean flag = false;
        String error = check(info);
        if (!"".equals(error))
        {
            throw new Exception(error);
        }
        if (CommonUtil.TYPE_ROLE.equals(info.getType()))
        {
            RoleInfo roleInfo = null;
            // 根据角色名称查找角色
            try
            {
                roleInfo = roleInfoDao.selectRoleByName(info.getName());
            } catch (Exception e)
            {
                e.printStackTrace();
                throw new Exception("更新角色操作过程中查找角色信息失败！");
            }
            if (roleInfo != null && !roleInfo.getId().equals(info.getId()))
            {
                throw new Exception("该角色名称已存在，更新失败！");
            }
        }
        if (CommonUtil.TYPE_POST.equals(info.getType()))
        {
            RoleInfo roleInfo = null;
            // 根据角色名称查找角色
            try
            {
                roleInfo = roleInfoDao.selectPostByName(info.getName());
            } catch (Exception e)
            {
                e.printStackTrace();
                throw new Exception("更新岗位操作过程中查找岗位信息失败！");
            }
            if (roleInfo != null && !roleInfo.getId().equals(info.getId()))
            {
                throw new Exception("该岗位名称已存在，更新失败！");
            }
        }
        try
        {
            roleInfoDao.updateByPrimaryKey(info);
        } catch (Exception e)
        {
            e.printStackTrace();
            if (CommonUtil.TYPE_POST.equals(info.getType()))
            {
                throw new Exception("更新岗位信息失败！");
            } else
            {
                throw new Exception("更新角色信息失败！");
            }
        }
        flag = true;

        return flag;
    }

    public void addRole(RoleInfo info) throws Exception
    {
        String error = check(info);
        if (!"".equals(error))
        {
            throw new Exception(error);
        }
        if (CommonUtil.TYPE_ROLE.equals(info.getType()))
        {
            // 根据角色名称查找角色
            RoleInfo roleInfo = roleInfoDao.selectRoleByName(info.getName());
            if (roleInfo != null)
            {
                throw new Exception("该角色名称已存在，添加失败！");
            }
        }
        if (CommonUtil.TYPE_POST.equals(info.getType()))
        {
            // 根据角色名称查找角色
            RoleInfo roleInfo = roleInfoDao.selectPostByName(info.getName());
            if (roleInfo != null)
            {
                throw new Exception("该岗位名称已存在，添加失败！");
            }
        }
        try
        {
            roleInfoDao.insert(info);
        } catch (Exception e)
        {
            e.printStackTrace();
            if (CommonUtil.TYPE_POST.equals(info.getType()))
            {
                throw new Exception("岗位信息保存失败！");
            } else
            {
                throw new Exception("角色信息保存失败！");
            }
        }
    }

    /**
     * @return the roleInfoDao
     */
    public RoleInfoDao getRoleInfoDao()
    {
        return roleInfoDao;
    }

    /**
     * @param roleInfoDao the roleInfoDao to set
     */
    public void setRoleInfoDao(RoleInfoDao roleInfoDao)
    {
        this.roleInfoDao = roleInfoDao;
    }

    private String check(RoleInfo info)
    {
        String result = "";
        if (info.getName() == null || "".equals(info.getName()))
        {
            return "角色名称不能为空！";
        }
        if (info.getName().length() > 100)
        {
            return "角色名称字符长度不能超过100！";
        }
        if (info.getDomain() != null)
        {
            if (info.getDomain().length() > 40)
            {
                return "角色所属域字符长度不能超过40！";
            }
        }
        if (info.getDescription() != null)
        {
            if (info.getDescription().length() > 500)
            {
                return "角色描述字符长度不能超过500！";
            }
        }
        return result;
    }

    public RelationInfoDao getRelationInfoDao()
    {
        return relationInfoDao;
    }

    public void setRelationInfoDao(RelationInfoDao relationInfoDao)
    {
        this.relationInfoDao = relationInfoDao;
    }

    @Override
    public BaseDao<RoleInfo> getDao()
    {
        return roleInfoDao;
    }

    @Override
    public List<RoleInfo> findRoleByQueryCriteria(RoleInfo roleInfo)
    {
        return roleInfoDao.selectRoleByQueryCriteria(roleInfo);
    }

    @Override
    public long findRoleCountByQueryCriteria(RoleInfo roleInfo)
    {
        return roleInfoDao.selectRoleCountByQueryCriteria(roleInfo);
    }

    // 检测角色互斥
    public boolean checkRoleMutualExclusion(List<RoleInfo> list) throws Exception
    {
        for (int i = 0; i < list.size(); i++)
        {
            RoleInfo role = list.get(i);
            String id = role.getId();
            List<String> temp = this.findMERoleById(id);
            if (temp == null || temp.size() <= 0)
            {
                continue;
            }
            for (int j = 0; j < list.size(); j++)
            {
                RoleInfo role1 = list.get(j);
                if (id.equals(role1.getId()))
                {
                    continue;
                }
                if (temp.contains(role1.getId()))
                {
                    throw new Exception(String.format("错误：[%s]角色与[%s]角色互斥", role.getName(), role1.getName()));
                }
            }
        }
        return true;
    }

    private List<String> findMERoleById(String menuID) throws Exception
    {
        // 根据角色id查询所有互斥
        List<String> target = new ArrayList<String>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("mainId", menuID);
        map.put("type", CommonUtil.RELATION_ME_ROLE);
        List<String> subIds = relationInfoDao.selectSubIdList(map);
        if (subIds != null && subIds.size() > 0)
        {
            target.addAll(subIds);
        }
        return target;
    }   
}
