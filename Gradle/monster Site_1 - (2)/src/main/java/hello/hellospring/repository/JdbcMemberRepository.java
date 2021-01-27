package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.sql.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;


public class JdbcMemberRepository {

	private JdbcTemplate jdbc;
	
	public JdbcMemberRepository(JdbcTemplate jdbc)
	{
		this.jdbc = jdbc;
	}
   
    
	public boolean login(Member member)
	{

		List retList;
		
		String email = member.getEmail();
		String password = member.getPassword();
		
		
		String sql = "select * from storyFlow.member where email = '"+member.getEmail()+"' and password = '"+member.getPassword()+"'";
	
		
		retList = jdbc.queryForList(sql);
		
		System.out.println(retList);
		
		if(retList.size() == 1)
		{
			System.out.println("로그인 성공");
			return true;
		}
		else
		{
			System.out.println("로그인 실패");
			return false;
		}
	}
	
    public void register(Member member)
    {
    	
    	String name = member.getName();
    	String password = member.getPassword();
    	String email = member.getEmail();
    	
    	String sql = "insert into storyFlow.member(name,email,password) values('"+name+"','"+email+"','"+password+"')";
 

    	try {
    	jdbc.execute(sql);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
  
}
