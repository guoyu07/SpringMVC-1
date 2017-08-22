package com.abc.usermanage.datamapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abc.usermanage.model.AccountInfo;

public interface AccountDataMapper 
{
	/**
	 * ��ѯ���������û���¼��
	 * @param AccountInfo ��ѯ�û���������
	 * @return ���������û���¼����
	 * @throws Exception �쳣��Ϣ
	 */
	int getAccountCount(@Param(value="queryAccount") AccountInfo AccountInfo) throws Exception;
	
	/**
	 * ��ѯ���������û��б�
	 * @param queryAccount ��ѯ�û���������
	 * @param startIndex ��ʼ������
	 * @param endIndex ����������
	 * @return ���������û��б�
	 * @throws Exception �쳣��Ϣ
	 */
	List<AccountInfo> queryAccountList(@Param(value="queryAccount") AccountInfo queryAccount,@Param(value="startIndex") int startIndex, @Param(value="endIndex") int endIndex) throws Exception;
}
