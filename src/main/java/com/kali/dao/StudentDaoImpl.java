package com.kali.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kali.beans.Student;

public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String add(Student student) {
		int rowCount=jdbcTemplate.update("insert into student04 values('"+student.getSid()+"','"
				+student.getSname()+"','"+student.getSaddr()+"')");
		String status="";
		if(rowCount==1) {
			status="success";
		}else {
			status="failure";
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		List<Student> listStd=jdbcTemplate.query("Select *from student04 where sid='"
				+sid+"'", (rs,rowNum)->{
				Student std=new Student();
				std.setSid(rs.getString("SID"));
				std.setSname(rs.getString("SNAME"));
				std.setSaddr(rs.getString("SADDR"));
				return std;
				});

		return listStd.isEmpty()?null:listStd.get(0);
	}

	@Override
	public String update(Student student) {
		int rowCount=jdbcTemplate.update("update student04 set SNAME = '"+student.getSname()+
				"',SADDR= '"+student.getSaddr()+"' where SID = '"+student.getSid()+"'");
		String status="";
		if(rowCount==1) {
			status="SUCCESS";
		}else {
			status="FAILURE";
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		String status="";
		int rowCount=jdbcTemplate.update("delete from student04 where sid = '"+sid+"'");
		if(rowCount==1) {
			status="SUCCESS";
		}else {
			status="FAILURE";
		}
		return status;
	}

}
