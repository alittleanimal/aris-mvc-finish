package com.accenture.aris.inventory.business.repository;

import com.accenture.aris.inventory.business.entity.GradeEntity;

public interface GradeRepository {
	GradeEntity selectByUseridCno(int userid, int cno);
	int update(GradeEntity record);
	int insert(GradeEntity record);
	int deleteByUseridCno(int userid, int cno);
}
