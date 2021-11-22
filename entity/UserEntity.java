package com.example.serve.entity;


	import javax.persistence.Entity;
	import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;
	import lombok.ToString;

	import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

	@Getter
	@Setter
	@NoArgsConstructor
	@Entity
	//@Table(name="user_entity",catalog = "user_database")
	@ToString
	
	public class UserEntity {
		
		@Id
		@GenericGenerator(name = "user" , strategy="increment")
		@GeneratedValue(generator="user")
		private int userId;
		private String firstName;
		private String lastName;
		private String designation;
		private String code;
		private long contact;
		private String email;
		private String country;
		private String gender;
		private String address;
		
	
		}
		

	

