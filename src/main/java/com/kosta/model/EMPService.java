package com.kosta.model;

import java.util.List;
import java.util.Map;

import com.kosta.dto.EMPVO;
import com.kosta.dto.JobVO;
// ����� -> controller --> service --> DAO -> DB
//		<-			  <--		  <--	  <-
public class EMPService {
	EMPDAO empDAO = new EMPDAO();
	//1.���������ȸ
		public List<EMPVO> selectAll() {
			return empDAO.selectAll();
			
		}
		public List<JobVO> selectJobAll() {
			return empDAO.selectJobAll();
		}
		public Map<Integer, String> selectManagerAll() {
			return empDAO.selectManagerAll();
		}
		//2.������ȸ(Ư���μ�)
		public List<EMPVO> selectByDept(int deptid) {
			return empDAO.selectByDept(deptid);
			
		}
		//3.������ȸ(Ư���Ŵ���)
		public List<EMPVO> selectByManager(int mid) {
			return empDAO.selectByManager(mid);
			
		}
		//4.������ȸ(Ư��JOB)
		public List<EMPVO> selectByJob(String job_id) {
			return empDAO.selectByJob(job_id);
			
		}
		//5.������ȸ(Ư�� deptid, jobid, salary, hire_date)
		public List<EMPVO> selectByCondition(int deptid, String job_id, int sal, String hire_date) {
			return empDAO.selectByCondition(deptid, job_id, sal, hire_date);
			
		}
		//6.Ư������ �ѰǸ� ��ȸ
		public EMPVO selectById(int empid) {
			return empDAO.selectById(empid);
			
		}
		public EMPVO selectByEmail(String empEmail) {
			return empDAO.selectByEmail(empEmail);
		}
		//7.insert
		public int empInsert(EMPVO emp) {
			return empDAO.empInsert(emp);
		}
		//8.update(Ư������1�� ����)
		public int empUpdate(EMPVO emp) {
			return empDAO.empUpdate(emp);
		}
		//9.update(���� department_id�� �ش��ϴ� ������ ����)
		public int empUpdateByDept(EMPVO emp, int deptid) {
			return empDAO.empUpdateByDept(emp, deptid);
		}
		//10.delete(Ư������ 1�� ����)
		public int empDelete(int empid) {
			return empDAO.empDelete(empid);
		}
		//11.delete(���� department_id�� �ش��ϴ� ������ ����)
		public int empDeleteByDept(int deptid) {
			return empDAO.empDeleteByDept(deptid);
		}
}
