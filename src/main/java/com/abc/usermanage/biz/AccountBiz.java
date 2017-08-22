package com.abc.usermanage.biz;

import java.util.List;

import com.abc.usermanage.model.AccountInfo;

public interface AccountBiz 
{
	/**
	 * ��ѯ���������û���¼��
	 * @param queryUser ��ѯ�û���������
	 * @return ���������û���¼����
	 * @throws Exception �쳣��Ϣ
	 */
	int getAccountCount(AccountInfo queryUser) throws Exception;
	
	/**
	 * ��ѯ���������û��б�
	 * @param queryUser ��ѯ�û���������
	 * @param startIndex ��ʼ������
	 * @param endIndex ����������
	 * @return ���������û��б�
	 * @throws Exception �쳣��Ϣ
	 */
	List<AccountInfo> queryAccountList(AccountInfo queryUser,int startIndex, int endIndex) throws Exception;
}
