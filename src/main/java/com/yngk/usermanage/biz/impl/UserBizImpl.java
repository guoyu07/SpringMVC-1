package com.yngk.usermanage.biz.impl;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;
import com.yngk.usermanage.biz.UserBiz;
import com.yngk.usermanage.dao.RelationInfoDao;
import com.yngk.usermanage.dao.UserInfoDao;
import com.yngk.usermanage.model.UserInfo;
import com.yngk.usermanage.util.CommonUtil;
import com.yngk.usermanage.vo.UserInfoVo;
import com.yngk.utils.biz.BaseBizImpl;
import com.yngk.utils.common.Func;
import com.yngk.utils.dao.BaseDao;
import com.yngk.utils.system.SystemConfigUtil;

import sun.misc.BASE64Encoder;

/**
 * @ClassName: UserBizImpl
 */
@Service
public class UserBizImpl extends BaseBizImpl<UserInfo> implements UserBiz,Serializable
{

    private static final long serialVersionUID = 4792540191315843483L;
    @Autowired
    private UserInfoDao userInfoDao;
//    private IWebStarterRegistryService registerService;
    @Autowired
    private RelationInfoDao relationInfoDao;
//    private UserPwdDao userPwdDao;

    @Override
    public List<UserInfo> getByUserName(String userName)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", userName);
        return userInfoDao.selectByUserName(map);
    }
   
    @Override
    public UserInfo getByLoginName(String loginName)
    {
        return userInfoDao.selectByLoginName(loginName.toUpperCase());
    }

    @Override
    public List<UserInfo> getListByGroup(String groupId)
    {
        // TODO Auto-generated method stub
        return userInfoDao.selectListByGroupId(groupId);
    }

    @Override
    public void addUserInfo(UserInfoVo userInfo) throws Exception
    {
    	// 校验用户信息
    	validUserInfo(userInfo);
    	// 加密密码
    	this.setUserPwd(userInfo);
    	// 统一设置用户名为小写
        String userLogin = userInfo.getUserLogin();
        userInfo.setUserLogin(userLogin.toLowerCase());
        userInfo.setGroupId("123456");
        // 生成ID
        userInfo.setId(UUID.randomUUID().toString());
        userInfo.setUpdateTime(new Date());
        userInfo.setDataState(CommonUtil.STATE_ENABLE);        
        
        // 添加用户
        if (userInfoDao.insertSelective(userInfo) <= 0)
        {
        	throw new Exception("创建用户信息失败，请确认！");        	
        }
    }
    
    // 校验用户信息
    private void validUserInfo(UserInfoVo userInfo) throws Exception
    {
    	 if (StringUtils.isNullOrEmpty(userInfo.getId()))
    	 {
    		 // 新增用户信息
	         if (StringUtils.isNullOrEmpty(userInfo.getUserLogin()))
	         {
	             throw new Exception("账号不能为空!");
	         }
	         if (userInfo.getUserLogin().length() > 30)
	         {
	        	 throw new Exception("用户名不能超过30个字符!");
	         }         
	         if (this.getByLoginName(userInfo.getUserLogin()) != null)
	         {
	        	 throw new Exception(String.format("%s用户名已存在!", userInfo.getUserLogin()));
	         }
	         
	         if (StringUtils.isNullOrEmpty(userInfo.getPwd()))
	         {
	        	 throw new Exception("密码不能为空!");
	         }
	         
	         if (StringUtils.isNullOrEmpty(userInfo.getSecondPwd()) || !userInfo.getSecondPwd().equals(userInfo.getPwd()))
	         {
	        	 throw new Exception("两次输入密码不一致!");
	         }
    	 }
         
         if (StringUtils.isNullOrEmpty(userInfo.getName()))
         {
        	 throw new Exception("姓名不能为空!");
         }         

         
//         if (selectedGroup == null)
//         {
//             setErrorMessage("请先选择部门!");
//             super.addCallbackParam(flag);
//             return;
//         }         
         
         if (userInfo.getMobilePhone().length() > 0 && !Func.isMobileNum(userInfo.getMobilePhone()))
         {
        	 throw new Exception("手机号码格式错误！");
         }
         if (userInfo.getEmail().length() > 0 && !Func.isEmail(userInfo.getEmail()))
         {
        	 throw new Exception("邮箱格式错误！");
         }        
    }
    
    @Override
    public boolean deleteUserInfo(String id)throws Exception
    {
        boolean flag = false;
        int i = userInfoDao.deleteByPrimaryKey(id);
        if (i >= 0)
        {
            flag = true;
        }
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("mainId", id);
//        int j = 
        relationInfoDao.deleteByDetail(map);
//        if (j > 0)
//        {
//            CommonUtil.clearCache();
//        }
        return flag;
    }
    

    @Override
    public UserInfo getUserInfoById(String id)throws Exception
    {
        // TODO Auto-generated method stub
        return userInfoDao.selectByPrimaryKey(id);
    }

    
    @Override
    public boolean updateUserInfo(UserInfo userInfo) throws Exception
    {
        boolean flag = false;
        int i = userInfoDao.updateByPrimaryKey(userInfo);
        if (i >= 0)
        {
            flag = true;
        }
        return flag;
    }

//    @Override
//    public boolean updateHisPwd(String userId, String pwd) throws Exception
//    {
//        UserPwd record = new UserPwd();
//        record.setId(UUID.randomUUID().toString());
//        record.setUserId(userId);
//        record.setPwd(pwd);
//        record.setUpdateTime(new Date());
//        userPwdDao.insert(record);
//        return true;
//    }
    
    public String getDefaultSecurity() throws Exception
    {
//        IRegisterFolder folder = getRegisterService().getFolder(CommonUtil.ROOT + CommonUtil.SECURITY);
//        if (folder == null)
//        {
//            // 节点路径：/AccountManager/SECURITY
//            folder = registerService.createFolder(CommonUtil.ROOT + CommonUtil.SECURITY, "");
//        }
//        // 读取默认密码
//        IRegisterAttribute attr = folder.getAttributeByName(CommonUtil.SECURITY_DEFAULT);
//        if (attr == null)
//        {
//            // 密码长度（默认最小8位）
//            RegAttribute attribute = new RegAttribute();
//            attribute.setAttrName(CommonUtil.SECURITY_DEFAULT);
//            attribute.setAttrValue("booway2015");
//            attribute.setDescription("默认密码");
//            attr = folder.createAttribute(attribute, "");
//        }
//
//        return attr.getValue();
    	
    	 return SystemConfigUtil.getSystemConfig(CommonUtil.SECURITY_DEFAULT);
    }
    
    public String getIsNeedInputPwd() throws Exception
    {
//        IRegisterFolder folder = getRegisterService().getFolder(CommonUtil.ROOT + CommonUtil.SECURITY);
//        if (folder == null)
//        {
//            // 节点路径：/AccountManager/SECURITY
//            folder = registerService.createFolder(CommonUtil.ROOT + CommonUtil.SECURITY, "");
//        }
//        // 读取默认密码
//        IRegisterAttribute attr = folder.getAttributeByName(CommonUtil.SECURITY_ISNEEDINPUTPWD);
//        if (attr == null)
//        {
//            // 密码长度（默认最小8位）
//            RegAttribute attribute = new RegAttribute();
//            attribute.setAttrName(CommonUtil.SECURITY_ISNEEDINPUTPWD);
//            attribute.setAttrValue("true");
//            attribute.setDescription("新建用户是否需要输入密码！");
//            attr = folder.createAttribute(attribute, "");
//        }
//
//        return attr.getValue();
    	
    	return SystemConfigUtil.getSystemConfig(CommonUtil.SECURITY_ISNEEDINPUTPWD);
    }

    /**
     * @return the userInfoDao
     */
    public UserInfoDao getUserInfoDao()
    {
        return userInfoDao;
    }

    /**
     * @param userInfoDao the userInfoDao to set
     */
    public void setUserInfoDao(UserInfoDao userInfoDao)
    {
        this.userInfoDao = userInfoDao;
    }

    
    @Override
    public BaseDao<UserInfo> getDao()
    {
        return this.userInfoDao;
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
    public List<UserInfo> selectUserByQueryCriteria(UserInfo userInfo)
    {
        // TODO Auto-generated method stub
        return userInfoDao.selectUserByQueryCriteria(userInfo);
    }

    @Override
    public long selectUserCountByQueryCriteria(UserInfo userInfo)
    {
        // TODO Auto-generated method stub
        return userInfoDao.selectUserCountByQueryCriteria(userInfo);
    }
    
    @Override
    public List<UserInfo> getByUserRole(String roleId, String type)
    {
         Map<String, String> map = new HashMap<String, String>();
         map.put("roleId", roleId);
         map.put("type", type);
        return userInfoDao.selectByUserRole(map);
    }

    @Override
    public List<UserInfo> getManagerListByUserId(String userId)
    {
        List<UserInfo> result = new ArrayList<UserInfo>();
        HashMap<String, String> temp = new HashMap<String, String>();
        // 获取用户所在部门
        UserInfo userInfo = userInfoDao.selectByPrimaryKey(userId);
        String groupId = userInfo.getGroupId();
        // 获取管理该部门的用户
        Map<String, String> map = new HashMap<String, String>();
        map.put("subId", groupId);
        map.put("type", "userMgrGroup");
        List<String> userIdList = relationInfoDao.selectMainIdList(map);
        for (String id : userIdList)
        {
            temp.put(id, id);
        }
        // 获取管理该用户的用户
        map = new HashMap<String, String>();
        map.put("subId", userId);
        map.put("type", "userMgrUser");
        userIdList = relationInfoDao.selectMainIdList(map);
        
        for (String id : userIdList)
        {
            temp.put(id, id);
        }
        temp.remove(userId);
        for (String id : temp.keySet())
        {
            UserInfo user = userInfoDao.selectByPrimaryKey(id);
            if (null != user)
            {
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public List<UserInfo> selectRelationUserList(String userId)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", userId);
        return userInfoDao.selectRelationUserList(map);
    }
    
    public List<UserInfo> getListByGroupIdNoRelationNum(String groupId)
    {
      return this.userInfoDao.selectListByGroupIdNoRelationNum(groupId);
    }

//    @Override
//    public UserPwd getUserHisPwdById(String userId)
//    {
//        List<UserPwd> pwdList = userPwdDao.getUserHisPwdById(userId);
//        if (pwdList != null && pwdList.size() > 0)
//        {
//            return pwdList.get(0);
//        }
//        return null;
//    }
    
    @Override
    public boolean deleteByUserId(String userId)
    {
        boolean flag = false;
//        userPwdDao.deleteByUserId(userId);
        return flag;
    }

	@Override
	public boolean validatePwd(String newPWD, UserInfo userInfo) throws Exception
	{
		String selectPwdForm = SystemConfigUtil.getSystemConfig(CommonUtil.PWD_FORM);
		String pwdLength = SystemConfigUtil.getSystemConfig(CommonUtil.SECURITY_LENGTH);
		String defPwd = getDefaultSecurity();
//		try
//        {
//            // 获取密码格式配置
//            IRegisterFolder folder = getRegisterService().getFolder(CommonUtil.ROOT + CommonUtil.SECURITY);
//            // 读取密码长度
//            IRegisterAttribute attr = folder.getAttributeByName(CommonUtil.SECURITY_LENGTH);
//            if (attr == null)
//            {
//                // 密码长度（默认最小8位）
//                RegAttribute attribute = new RegAttribute();
//                attribute.setAttrName(CommonUtil.SECURITY_LENGTH);
//                attribute.setAttrValue("8");
//                attribute.setDescription("限定密码最小长度");
//                attr = folder.createAttribute(attribute, "");
//            }
//            pwdLength = attr.getValue();
//
//            folder = getRegisterService().getFolder(CommonUtil.ROOT + CommonUtil.SECURITY);
//            // 读取密码构成（默认为字母数字组合）
//            attr = folder.getAttributeByName(CommonUtil.PWD_FORM);
//            if (attr == null)
//            {
//                // 密码构成（默认为字母数字组合）
//                RegAttribute attribute = new RegAttribute();
//                attribute.setAttrName(CommonUtil.PWD_FORM);
//                attribute.setAttrValue(CommonUtil.LETTERS_AND_NUM);
//                attribute.setDescription("");
//                attr = folder.createAttribute(attribute, "");
//            }
//            selectPwdForm = attr.getValue();
//            
//            defPwd = getDefaultSecurity();
//        } catch (Exception e)
//        {
//        	
//            throw new Exception("密码强度相关配置读取失败！");
//        }
		
		if (newPWD.equals(defPwd))
        {
			throw new Exception("新密码不能和默认初始密码相同!");
        } 
        // 口令中不得包含用户名
        if (newPWD.contains(userInfo.getUserLogin()) || newPWD.contains(userInfo.getName()))
        {
        	throw new Exception("新密码不能包含登录/用户名!");
        } 
        // 口令中不得包含系统默认口令及其变种
        String temp = defPwd;
        String[] array = temp.split(",");
        for (String str : array)
        {
            if (newPWD.contains(str))
            {
            	throw new Exception("新密码不能包含系统默认密码（如：" + temp + "等）!");
            } 
        }
        if (CommonUtil.LETTERS_AND_NUM.equals(selectPwdForm))
        {
            if (!(Character.isLetter(newPWD.charAt(0)) && isLettersorNum(newPWD) && newPWD.length() >= Integer
                    .parseInt(pwdLength)))
            {
            	throw new Exception("新密码必须为数字、字母组合(字母开头)且长度不小于" + pwdLength + "个字符！");
            }
        }
        // 特殊字符包括
        else if (CommonUtil.SPECIAL.equals(selectPwdForm))
        {
            String pattern4 = "^(?![a-zA-Z0-9]+$)(?![^a-zA-Z/D]+$)(?![^0-9/D]+$).{0,20}$";
            if (!newPWD.matches(pattern4) || newPWD.length() < Integer.parseInt(pwdLength))
            {
            	throw new Exception("新密码必须为字母、数字、特殊符号的组合，长度不小于" + pwdLength + "个字符！");
            }
        }
        else if (!CommonUtil.NOLIMIT.equals(selectPwdForm))
        {
            if (newPWD.length() < Integer.parseInt(pwdLength))
            {
            	throw new Exception("新密码长度不能小于" + pwdLength + "个字符！");

            }
        }
		return true;
	}
	
    private boolean isLettersorNum(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if (!(Character.isLetter(str.charAt(i))) && !(Character.isDigit(str.charAt(i))))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public UserInfo getUsersByEName(String eName)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", eName);
        List<UserInfo> list = this.userInfoDao.getUsersByEName(map);
        if (null != list && list.size() > 0)
        {
            return list.get(0);
        }
        return null;
    }

	@SuppressWarnings("restriction")
	@Override
    public UserInfo setUserPwd(UserInfo userInfo) throws Exception
    {
//        // 设置安全密码
//        String type = System.getProperty(CommonUtil.SAFE_ENCODE_TYPE_FLAG);
//        if (CommonUtil.SAFE_ENCODE_TYPE_SM3.equals(type))
//        {
//            String ePwd = CommonUtil.encodeWithSM3(userInfo.getName(), userInfo.getPwd());
//            userInfo.setSafeEvalPwd(ePwd);
//        }
//        else
//        {
//            PasswordEncoder encoder = new RSAPasswordEncoder();
//            String ePwd = encoder.encodePassword(userInfo.getPwd(), null);
//            userInfo.setSafeEvalPwd(ePwd);
//        }
//        // 设置普通密码
//        PasswordEncoder passwordEncoder = SecurtiyApplicationContext.getPasswordEncoder();
//        String pwd = passwordEncoder.encodePassword(userInfo.getPwd(), null);
    	
    	// 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // base64再加密
        BASE64Encoder base64en = new BASE64Encoder();
        // 加密后的字符串
        String newPwd = base64en.encode(md5.digest(userInfo.getPwd().getBytes("utf-8")));
        userInfo.setPwd(newPwd);
        
        return userInfo;
    }

	@Override
	public void updateUserInfo(UserInfoVo userInfo) throws Exception 
	{
		// 校验用户信息
    	validUserInfo(userInfo);
    	// 清除不允许保存的信息
    	userInfo.setDataState("");
    	userInfo.setPwd("");
    	userInfo.setShowOrder(0);
    	userInfo.setUserLogin("");     
        
        // 添加用户
        if (userInfoDao.updateByPrimaryKeySelective(userInfo) <= 0)
        {
        	throw new Exception("编辑用户信息失败，请确认！");        	
        }
	}   

    
//    @Override
//    public List<UserPwd> getRencent2HisPwdById(String userId)
//    {
//        List<UserPwd> result = new ArrayList<UserPwd>();
//        List<UserPwd> pwdList = userPwdDao.getUserHisPwdById(userId);
//        if (pwdList == null)
//        {
//            return result;
//        }
//        if (pwdList.size() == 1)
//        {
//            result.add(pwdList.get(0));
//        }
//        else if (pwdList.size() >= 2)
//        {
//            result.add(pwdList.get(0));
//            result.add(pwdList.get(1));
//        }
//        return result;
//    }
    
//    @Override
//    public boolean insertInitHisPwd(String userId, String pwd) throws Exception
//    {
//        UserPwd record = new UserPwd();
//        record.setId(UUID.randomUUID().toString());
//        record.setUserId(userId);
//        record.setPwd(pwd);
//        record.setUpdateTime(new Date(0));
//        userPwdDao.insert(record);
//        return true;
//    }
}