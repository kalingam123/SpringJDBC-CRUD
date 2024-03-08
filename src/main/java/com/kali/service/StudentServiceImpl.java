package com.kali.service;

import com.kali.beans.Student;
import com.kali.dao.StudentDao;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public String addStudent(Student student) {
		
		return studentDao.add(student);
	}

	@Override
	public Student searchStudent(String sid) {
		
		return studentDao.search(sid);
	}

	@Override
	public String updateStudent(Student student) {
		
		return studentDao.update(student);
	}

	@Override
	public String deleteStudent(String sid) {
		
		return studentDao.delete(sid);
	}

}
