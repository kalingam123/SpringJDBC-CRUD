package com.kali.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import com.kali.beans.Student;
import com.kali.service.StudentService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentController extends MultiActionController{
	
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response)throws Exception {
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String saddr=request.getParameter("saddr");
		System.out.println(sid+" "+sname+" "+saddr+"");
		Student student=new Student();
		String status=studentService.addStudent(student);
		String message="";
		if(status.equalsIgnoreCase("success")) {
			message="Studend Added Successfully";
		}else {
			message="Student Insertion failure";
		}
		
		return new ModelAndView("status","message", message);
		
	}
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) {
		
		String sid=request.getParameter("sid");
		Student student=studentService.searchStudent(sid);
		String message="";
		if(student==null) {
			message="Student does not existed";
			return new ModelAndView("status","message",message);
		}else {
			return new ModelAndView("display", "student", student);
		}
				
	}
	public ModelAndView editform(HttpServletRequest request,HttpServletResponse response) {
		
		String sid=request.getParameter("sid");
		Student student=studentService.searchStudent(sid);
		String message="";
		if(student == null){
			message = "Student Does Not Exist";
			return new ModelAndView("status", "message", message);
		}else{
			request.setAttribute("student", student);
			return new ModelAndView("editform","student",student);
		}
	}
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) {
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String saddr=request.getParameter("saddr");
		Student std=new Student();
		std.setSid(sid);
		std.setSname(sname);
		std.setSaddr(saddr);
		String status=studentService.updateStudent(std);
		String message="";
		if(status.equalsIgnoreCase("success")) {
			message="Student Updation is Success";
		}else {
			message="Student Updation is Failure";
		}
		
		return new ModelAndView("status","message",message);
	}
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) {
		String sid=request.getParameter("sid");
		Student student=studentService.searchStudent(sid);
		String message="";
		if(student==null) {
			message="Student Does Not Existed";
		}else {
			String status=studentService.deleteStudent(sid);
			if(status.equalsIgnoreCase("success")) {
				message="Student Deleted Successfully";
			}else 
				message="Student Deletion Failure";
			}
		
		return new ModelAndView("status","message",message);
	}

}
