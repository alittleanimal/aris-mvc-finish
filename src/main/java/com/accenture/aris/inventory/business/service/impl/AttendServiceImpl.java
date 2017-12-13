package com.accenture.aris.inventory.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.aris.inventory.business.entity.AttendEntity;
import com.accenture.aris.inventory.business.entity.CourseEntity;
import com.accenture.aris.inventory.business.repository.AttendRepository;
import com.accenture.aris.inventory.business.repository.CourseRepository;
import com.accenture.aris.inventory.business.service.AttendService;

@Service
public class AttendServiceImpl implements AttendService {
	@Autowired
	private AttendRepository attendRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<CourseEntity> SelectAttendingCourse(String userID) {
		List<Integer> courseIdList = attendRepository.selectAttendCourseById(userID);
		CourseEntity courseEntity = new CourseEntity();
		List<CourseEntity> courseEntityList = new ArrayList<CourseEntity>();
		if (courseIdList == null) {
			return courseEntityList;
		}
		for (Integer courseid : courseIdList) {
			courseEntity = courseRepository.selectByCno(courseid);
			courseEntityList.add(courseEntity);
		}
		return courseEntityList;
	}

	@Override
	public boolean AddAttendence(int cno, String attendenceID) {
		int result1 = 0, result2 = 0;
		List<AttendEntity> attendEntityList = courseRepository.selectAttendByCno(cno);
		for (AttendEntity attendEntity:attendEntityList)
		{
			attendEntity.setAttendenceId(attendenceID);
		}
		int count = attendRepository.MaxCount(cno) + 1;
		AttendEntity attendEntity = attendEntityList.get(0);
		attendEntity.setStatus(1);
		attendEntity.setCount(count);
		result1 = attendRepository.insertIntoAttendance(attendEntity);
		for (AttendEntity attendList : attendEntityList) {
			attendList.setState("notattend");
			result2 = attendRepository.insertIntoAttendDetail(attendList);
		}
		if (result1 != 0 && result2 != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<AttendEntity> selectAttendenceDetail(int cno) {
		List<AttendEntity> attendEntityList = new ArrayList<AttendEntity>();
		attendEntityList = attendRepository.selectAllAttendByCno(cno);
		return attendEntityList;
	}

	@Override
	public boolean IsAttend(String userID, String attendenceID) {
		int result = attendRepository.updateAttendState(attendenceID, userID, "attend");
		if (result != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean IsNotAttend(String userID, String attendenceID) {
		int result = attendRepository.updateAttendState(attendenceID, userID, "notAttend");
		if (result != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<CourseEntity> SelectUnAttendingCourse(String userID) {
		List<Integer> courseIdList = attendRepository.selectUnAttendCourseById(userID);
		CourseEntity courseEntity = new CourseEntity();
		List<CourseEntity> courseEntityList = new ArrayList<CourseEntity>();
		if (courseIdList == null) {
			return courseEntityList;
		}
		for (Integer courseid : courseIdList) {
			courseEntity = courseRepository.selectByCno(courseid);
			courseEntityList.add(courseEntity);
		}
		return courseEntityList;
	}

	@Override
	public boolean endAttend(int cno, int count) {
		int status = 0;
		int temp = attendRepository.updateAttendStateByCnoCount(cno, count, status);
		if (temp!=0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<AttendEntity> selectAttendByIdCno(int cno, String user, String state) {
		List<AttendEntity> attendEntities = new ArrayList<AttendEntity>();
		attendEntities = attendRepository.selectAttendByIdCno(cno, user, state);
		return attendEntities;
	}

	@Override
	public List<AttendEntity> selectAttendByCnoCount(int cno, int count, String state) {
		List<AttendEntity> attendEntities = new ArrayList<AttendEntity>();
		attendEntities = attendRepository.selectAttendByCnoCount(cno, count, state);
		return attendEntities;
	}

	@Override
	public List<AttendEntity> selectAttendenceDetail(Integer cno, int status) {
		List<AttendEntity> attendEntities = new ArrayList<AttendEntity>();
		attendEntities = attendRepository.selectAttendenceDetail(cno, status);
		return attendEntities;
	}

	@Override
	public int MaxCount(int cno) {
		int temp = attendRepository.MaxCount(cno);
		return temp;
	}
	
	@Override
	public int getCno (String attendenceID){
		int cno = attendRepository.getCno(attendenceID);
		return cno;
	}
	
	@Override
	public int getCount (String attendenceID){
		int count = attendRepository.getCount(attendenceID);
		return count;
	}
	
	

}
