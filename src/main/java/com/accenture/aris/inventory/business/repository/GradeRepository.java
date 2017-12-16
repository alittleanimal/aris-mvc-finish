package com.accenture.aris.inventory.business.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.accenture.aris.inventory.business.entity.GradeEntity;

@Repository
public interface GradeRepository {
	List<GradeEntity>  getTestList(int cno); // 根据cno查询课程所有的考试信息 grade表

	List<GradeEntity>  getTestDetail (String testid); // 根据testid查询这次考试的所有成绩信息 grade_detail表
	
	int insertIntoGrade(GradeEntity gradeEntity); //创建一次新考试（grade表） 将选该课的所有学生加入到grade_detail中（根据cno查t_user_course,成绩为空）

	int insertIntoDetail(GradeEntity gradeEntity); //创建一次新考试（grade表） 将选该课的所有学生加入到grade_detail中（根据cno查t_user_course,成绩为空）
	
	GradeEntity  getOneDetail(int gradeid); //根据gradeid查询一次考试的一个学生成绩信息 (grade_detail表)

	int changeGrade (int gradeid,int grade); //根据gradeid更改学生的成绩信息 （grade_detail表）

	List<GradeEntity> getAllGradeByCnoUserid(int cno ,String userid);
}
