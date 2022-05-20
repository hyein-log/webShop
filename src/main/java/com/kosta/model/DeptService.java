package com.kosta.model;

import java.util.List;

import com.kosta.dto.DeptDTO;

//service : ����Ͻ� ���� �ۼ��Ѵ�.
//DB�۾��� DAO ȣ���Ѵ�.
public class DeptService {
		private DeptDAO deptDAO = new DeptDAO();
		//1. �����ȸ
		public List<DeptDTO> selectAll() {
			return deptDAO.selectAll();
		}
		//2. Ư���μ���ȸ(�μ��ڵ�� ��ȸ)
		public DeptDTO selectById(int deptid) {
			return deptDAO.selectById(deptid);
			
		}
		//3. �����ڵ�� ��ȸ
		public List<DeptDTO> selectByLocation(int locid) {
			return deptDAO.selectByLocation(locid);
			
		}
		//4. �űԺμ��Է�
		public int deptInsert(DeptDTO dept) {
			return deptDAO.deptInsert(dept);
		}
		//5. Ư���μ�����
		public int deptUpdate(DeptDTO dept) {
			return deptDAO.deptUpdate(dept);
		}
		//6. Ư���μ�����
		public int deptDelete(int deptid) {
			return deptDAO.deptDelete(deptid);
		}
}
