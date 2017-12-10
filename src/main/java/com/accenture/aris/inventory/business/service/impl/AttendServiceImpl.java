package com.accenture.aris.inventory.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.aris.inventory.business.entity.AttendEntity;
import com.accenture.aris.inventory.business.entity.CourseEntity;
import com.accenture.aris.inventory.business.repository.AttendRepository;
import com.accenture.aris.inventory.business.repository.CourseRepository;
import com.accenture.aris.inventory.business.service.AttendService;

@Service
public class AttendServiceImpl implements AttendService{

	@Autowired
	private AttendRepository attendRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public CourseEntity SelectAttendingCourse(String userID) {
		int courseid = attendRepository.selectAttendCourseById(userID);
		CourseEntity courseEntity = new CourseEntity();
		courseEntity = courseRepository.selectByCno(courseid);
		return courseEntity;
	}

	@Override
	public boolean AddAttendence(int cno, String attendenceID, int count) {
		int result1 = 0,result2 = 0;
		List<AttendEntity> attendEntityList= courseRepository.selectAttendByCno(cno);
		AttendEntity attendEntity = attendEntityList.get(0);
		attendEntity.setStatus(1);
		attendEntity.setCount(count);
		result1 = attendRepository.insertIntoAttendance(attendEntity);
		for (AttendEntity attendList : attendEntityList) {
			attendList.setState("attend");
			result2 = attendRepository.insertIntoAttendDetail(attendList);
		}
		if (result1!=0 && result2 != 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public AttendEntity selectAttendenceDetail(int cno) {
		AttendEntity attendEntity = new AttendEntity();
		attendEntity = attendRepository.selectAllAttendByCno(cno);
		return attendEntity;
	}

	@Override
	public boolean IsAttend(String userID, String attendenceID) {
		int result = attendRepository.updateAttendState(attendenceID, userID, "attend");
		if (result != 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean IsNotAttend(String userID, String attendenceID) {
		int result = attendRepository.updateAttendState(attendenceID, userID, "notAttend");
		if (result != 0) {
			return true;
		}else {
			return false;
		}
	}

}
