package com.luongloi.usermanagement.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// chú ý cấu hình phiên bản MySql phải như nhau trong application.properties và mysql-connector-java trong dependency trong file pom.xml
// link bai hoc
// https://www.codejava.net/frameworks/spring-boot/connect-to-mysql-database-examples
// https://techmaster.vn/posts/36182/spring-boot-11-huong-dan-spring-boot-jpa-mysql


@Entity
@Table(name = "users")
@Data
public class User implements Serializable{
	private static final long serialVersionUID = -297553281792804396L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int us_id;
	
	@Column(name = "us_username")
	private String username;
	
	@Column(name = "us_password")
	private String password;
	
	@Column(name = "us_group")
	private int group;
}
