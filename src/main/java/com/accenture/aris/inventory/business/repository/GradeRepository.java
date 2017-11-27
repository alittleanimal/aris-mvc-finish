package com.accenture.aris.inventory.business.repository;

import org.springframework.stereotype.Repository;

import com.accenture.aris.inventory.business.entity.GradeEntity;

@Repository
public interface GradeRepository {
	GradeEntity selectByUseridCno(int userid, int cno);
	int update(GradeEntity record);
	int insert(GradeEntity record);
	int deleteByUseridCno(int userid, int cno);
}
