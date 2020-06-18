package com.itwillbs.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemDAO;
import com.itwillbs.dao.MemDAOImpl;
import com.itwillbs.domain.MemberBean;
@Service
public class MemServiceImpl implements MemService{
	MemDAO memDAO;
	// xml 에서 set메서드를 통해서 객체생성한 값 전달
	@Inject
	public void setMemDAO(MemDAO memDAO) {
		this.memDAO = memDAO;
	}
	
	@Override
	public void insert(MemberBean mb) {
		System.out.println("MemServiceImpl - insert()");
		// 1. 객체생성 => 3군데 수정 필요
//		MemDAOImpl memDAOImpl = new MemDAOImpl();
//		memDAOImpl.insert();
		// 2. 부모 = 자식 객체 생성 => 1군데 수정 필요
//		MemDAO memDAO = new MemDAOImpl();
//		memDAO.insert();
		// 3. 부모=자식이 사용되는 곳 <= 스프링파일 xml 자식 객체생성 필요로 하는곳을 줌
		//    스프링에서 객체 생성하는 방식 : 의존관계주입(DI)
		
		// 가입날짜 처리
		mb.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		memDAO.insert(mb);
		
	}

	@Override
	public MemberBean userCheck(MemberBean mb) {
		
		return memDAO.userCheck(mb);
	}

	@Override
	public MemberBean info(String id) {
		
		return memDAO.info(id);
	}

	@Override
	public void update(MemberBean mb) {
		
		memDAO.update(mb);
		
	}

	@Override
	public void delete(String id) {
		memDAO.delete(id);
		
	}
	
	
}
