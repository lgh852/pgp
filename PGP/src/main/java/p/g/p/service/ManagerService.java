package p.g.p.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.ManagerDao;
import p.g.p.model.Manager;


public class ManagerService {
	
	ManagerDao dao;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	/*public int memberInsert(Manager manager) {
		dao = sqlSessionTemplate.getMapper(ManagerDao.class);
		System.out.println("service 목록" + manager);
		int resultCnt = dao.insertManager(manager);
		if (resultCnt > 0) {
			// insert 성공시
			System.out.println("회원가입 성공");
		} else {
			// 회원가입 실패시 -1 값 주입
			resultCnt = -1;
		}

		return resultCnt;
	}*/

	public Manager loginService(Manager manager, String id, String pw) {

		dao = sqlSessionTemplate.getMapper(ManagerDao.class);
		manager = (Manager) dao.loginSelect(id);
		if (manager != null) {
			// 로그인성공
			if (manager.getManager_pw() == pw) {
				// 비밀번호 있을시
				manager.setManager_pw("");
				return manager;
			}

		} else {
			// 로그인 실패
			return manager = null;
		}

		return manager;
	}
}
