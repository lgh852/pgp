package p.g.p.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import p.g.p.dao.Sb_dao;
import p.g.p.model.report;

public class Sb_report_service {
	
	Sb_dao dao;
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int reportSubmit(report report) {
		
		System.out.println(report);
		
		dao = sqlSessionTemplate.getMapper(Sb_dao.class);
		
		int result = dao.reportboard(report);
		
		if(result>0) {
			System.out.println("성공");
		}else {
			result=-1;
		}
		
		return result;
	}

}
