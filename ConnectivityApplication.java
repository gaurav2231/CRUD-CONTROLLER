package com.connectivity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ConnectivityApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ConnectivityApplication.class, args);
	}
	 @Override
	    public void run(String... args) throws Exception {
	        String sql = "INSERT INTO users (fullname, email, password) VALUES (?, ?, ?)";
	         
	        int result = jdbcTemplate.update(sql, "Gaurav saini", "gauravsaini@gmail.com", "Gaurav@123");
	         
	        if (result > 0) {
	            System.out.println("A new row has been inserted.");
	        }
	         
	    }
}
