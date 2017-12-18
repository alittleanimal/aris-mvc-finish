package com.accenture.aris.inventory.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.aris.inventory.business.entity.GradeEntity;
import com.accenture.aris.inventory.business.repository.CourseRepository;
import com.accenture.aris.inventory.business.repository.GradeRepository;
import com.accenture.aris.inventory.business.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<GradeEntity> getTestList(int cno) {
		List<GradeEntity> gradeEntities = gradeRepository.getTestList(cno);
		return gradeEntities;
	}

	@Override
	public List<GradeEntity> getTestDetail(String testid) {
		List<GradeEntity> gradeEntities = gradeRepository.getTestDetail(testid);
		return gradeEntities;
	}

	@Override
	public boolean createTest(GradeEntity gradeEntity) {
		int temp = gradeRepository.insertIntoGrade(gradeEntity);
		if (temp == 0) {
			return false;
		}
		List<String> usernameList = courseRepository.selectUserNameByCno(gradeEntity.getCno());
		for (String name : usernameList) {
			gradeEntity.setUsername(name);
			temp = gradeRepository.insertIntoDetail(gradeEntity);
			if(temp == 0){
				return false;
			}
		}
		return true;
	}

	@Override
	public GradeEntity getOneDetail(int gradeid) {
		GradeEntity gradeEntity = gradeRepository.getOneDetail(gradeid);
		return gradeEntity;
	}

	@Override
	public boolean changeGrade(int gradeid, int grade) {
		int temp = gradeRepository.changeGrade(gradeid, grade);
		if (temp != 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<GradeEntity> getStudentTestList(String userid) {
		List<Integer> course = courseRepository.selectByUserid(userid);
		List<GradeEntity> gradeEntities = new ArrayList<GradeEntity>();
		
		if (course.isEmpty()) {
			return gradeEntities;
		}
		
		for (int courseid : course) {
			List<GradeEntity> tempList = gradeRepository.getAllGradeByCnoUserid(courseid,userid);
			for (GradeEntity gradeEntity2 : tempList) {
				gradeEntities.add(gradeEntity2);
			}
		}
		return gradeEntities;
	}
	
	@Override
	public boolean endTest(String testid) {
		int result1 = gradeRepository.deleteTest(testid);
		int result2 = gradeRepository.deleteTestDetail(testid);
		if (result1 != 0) {
			return true;
		}else {
			return false;
		}
	}
	

	@Override
	public boolean endTestByCno(int cno) {
		int result2 = gradeRepository.deleteTestDetailByCno(cno);
		int result1 = gradeRepository.deleteTestByCno(cno);
		if (result1 != 0) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int getCnoBytestid(String testid) {
		int cno = gradeRepository.getCnoBytestid(testid);
		
		return cno;
		
	}
	

}
