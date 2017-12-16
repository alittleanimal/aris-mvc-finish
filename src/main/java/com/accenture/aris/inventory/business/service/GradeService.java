package com.accenture.aris.inventory.business.service;

import java.util.List;

import com.accenture.aris.inventory.business.entity.GradeEntity;

public interface GradeService {

	List<GradeEntity>  getTestList(int cno); // 根据cno查询课程所有的考试信息 grade表

	List<GradeEntity>  getTestDetail (String testid); // 根据testid查询这次考试的所有成绩信息 grade_detail表
	
	boolean createTest(GradeEntity gradeEntity); //创建一次新考试（grade表） 将选该课的所有学生加入到grade_detail中（根据cno查t_user_course,成绩为空）

	GradeEntity  getOneDetail(int gradeid); //根据gradeid查询一次考试的一个学生成绩信息 (grade_detail表)

	boolean changeGrade (int gradeid,int grade); //根据gradeid更改学生的成绩信息 （grade_detail表）

	List<GradeEntity>  getStudentTestList(String userid); //根据学生userid查找t_user_course表所选的课cno，再用cno查grade和grade_detail得到学生所选课的考试信息
	
}
