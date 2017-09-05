package com.yngk.usermanage.util;

/**
 * 
 * @author Administrator
 *
 */
public class CommonUtil
{
	
	/** 项目根目录 */
	public static final String ROOT = "/AccountManager";
	/** 密码策略目录 */
	public static final String SECURITY = "/SECURITY";
	/** 访问策略目录 */
    public static final String STRATEGY = "/STRATEGY";
    /** 访问策略目录 */
    public static final String STARTIP = "startIP";
    /** 访问策略目录 */
    public static final String ENDIP = "endIP";
    /** 访问策略目录 */
    public static final String STARTTIME = "startTime";
    /** 访问策略目录 */
    public static final String ENDTIME = "endTime";
	/** 登录失败次数 */
	public static final String LOGIN_FAIL_NUM = "LOGIN_FAIL_NUM";
	/** 锁定时间 */
	public static final String LOCK_TIME = "LOCK_TIME";
	/** 密码长度 */
	public static final String SECURITY_LENGTH = "SECURITY_LENGTH";
	/** 默认密码 */
    public static final String SECURITY_DEFAULT = "SECURITY_DEFAULT";
	/** 新建用户是否需要输入密码 */
    public static final String SECURITY_ISNEEDINPUTPWD = "SECURITY_ISNEEDINPUTPWD";
	/** 有效时间 */
	public static final String VALIDITY_TIME = "VALIDITY_TIME";
	/** 密码构成 */
	public static final String PWD_FORM = "PWD_FORM";
	/** 密码构成（无限制） */
	public static final String NOLIMIT = "NOLIMIT";
	/** 密码构成（存在特殊符号） */
	public static final String SPECIAL = "SPECIAL";
	/** 密码构成(字母数字组合) */
	public static final String LETTERS_AND_NUM = "LETTERS_AND_NUM";
	
	/** session最大时间 */
	public static final String SESSION_MAX_TIME = "SESSION_MAX_TIME";
	
	/** 用户最大在线数量 */
	public static final String ACCOUNT_ONLINE_MAX = "ACCOUNT_ONLINE_MAX";
	
	/** 当前项目目录 */
	private static String contextPath = "";
	
	public static String STRATEGY_RELATION_TYPE = "用户策略";
	
	/** 角色类型 */
	public static String TYPE_ROLE = "role";
	/** 岗位类型 */
	public static String TYPE_POST = "post";
	/** 角色菜单关联关系 */
	public static String RELATION_ROLE_PAGE = "rolePage";
	public static String MANDARIN_RELATION_ROLE_PAGE = "角色-菜单关联";
	/** 用户菜单关联关系 */
	public static String RELATION_USER_PAGE = "userPage";
	public static String MANDARIN_RELATION_USER_PAGE = "用户-菜单关联";
	/** 用户关联用户关系 */
	public static String RELATION_USER_USER = "userMgrUser";
	/** 用户关联部门关系 */
	public static String RELATION_USER_GROUP = "userMgrGroup";
	/** 用户关联角色关系 */
	public static String RELATION_USER_ROLE = "userRole";
	public static String MANDARIN_RELATION_USER_ROLE = "用户-角色关联";
	/** 用户关联岗位关系 */
	public static String RELATION_USER_POST = "userPosition";
	/** 角色功能资源关联关系 */
	public static String RELATION_ROLE_FUNC = "roleRes";
	public static String MANDARIN_RELATION_ROLE_FUNC = "角色-功能关联";
	/** 用户功能资源关联关系 */
	public static String RELATION_USER_FUNC = "userRes";
	public static String MANDARIN_RELATION_USER_FUNC = "用户-功能关联";
	
	/** 本次操作数据库为新增还是删除 */
	public static String ADD_AUTH = "addAuth";
	public static String DELETE_AUTH = "deleteAuth";
	
    /**
     * 互斥菜单
     */
    public static String RELATION_ME_MENU = "MutualExclusionMenu";
    /**
     * 互斥角色
     */
    public static String RELATION_ME_ROLE = "MutualExclusionRole";	
	/** 启动状态*/
	public static String STATE_ENABLE = "启用";
	/** 禁用状态 */
	public static String STATE_DISABLE = "禁用";
	/** 删除状态*/
	public static String STATE_DELETE = "删除";
	
    public final static String SET_USER_RES = "用户按钮资源分配";
    
    public final static String SET_USER_PAGE = "用户页面资源分配";
    
    public final static String SET_USER_ROLE = "用户角色资源分配";
    
    public final static String SET_ROLE_RES = "角色按钮资源分配";
    
    public final static String SET_ROLE_PAGE = "角色页面资源分配";	
    
    /** 安全评测功能开关*/
    public static String START_SAFETY_EVALUATION = "startSafetyEvaluation";
    
    public static String SAFE_ENCODE_TYPE_FLAG = "safeEncodeType";//安全评测加密类型标志位
    
    public static String SAFE_ENCODE_TYPE_SM3 = "SM3";//安全评测加密类型"SM3"
    
    public static String SAFE_ENCODE_TYPE_RSA = "RSA";//安全评测加密类型"RSA"
//	/**
//	 * 获取当前项目目录
//	 * @return
//	 */
//	public static String getRootPath()
//	{
//		if (contextPath.equals(""))
//		{
////			contextPath = 
//		}
//		return contextPath;
//	}
	
//    public static String encodeWithSM3(String loginName, String pwd)
//    {
//        String result = "";
//        PasswordEncoder passwordEncoder = new SM3PasswordEncoder();
//        String content = loginName.toUpperCase() + ":" + pwd;
//        result = passwordEncoder.encodePassword(content, null);
//        return result;
//    }
    
//    public static void clearCache()
//    {
//        getCache().removeAll();
//        getCache().clearStatistics();
//    }
//    public static Cache getCache()
//    {
//        return getCacheService().getCache("usermanage");
//    }
//    
//    public static ICacheService getCacheService()
//    {
//        return (ICacheService) getBean("cacheService");
//    }
//    
//    public static Object getBean(String beanName)
//    {
//        return BundleBeanFactory.getBean(beanName);
//    }
}
