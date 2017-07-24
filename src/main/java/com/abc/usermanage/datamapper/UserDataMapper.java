package com.abc.usermanage.datamapper;

import java.util.List;

import com.abc.usermanage.model.User;

public interface UserDataMapper 
{
	/**
	 * ��ѯ���������û���¼��
	 * @param queryUser ��ѯ�û���������
	 * @return ���������û���¼����
	 * @throws Exception �쳣��Ϣ
	 */
	int getUserCount(User queryUser) throws Exception;
	
	/**
	 * ��ѯ���������û��б�
	 * @param queryUser ��ѯ�û���������
	 * @param startIndex ��ʼ������
	 * @param endIndex ����������
	 * @return ���������û��б�
	 * @throws Exception �쳣��Ϣ
	 */
	List<User> queryUserList(User queryUser,int startIndex, int endIndex) throws Exception;
}
