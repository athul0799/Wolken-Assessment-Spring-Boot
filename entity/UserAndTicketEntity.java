package com.example.serve.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="user_table",catalog = "user_database")
@ToString
public class UserAndTicketEntity {
	

	@Id
	@GenericGenerator(name = "athul" , strategy="increment")
	@GeneratedValue(generator="athul")
	
	
	
	private TicketEntity ticketEntity;
	
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
	private int ticketId;
	

	private String TicketType;
	private Date date;
	private String QueriesType;
	private String queries;
	private String status;
	private String priority;
	private String AgentId;
	private String TechieId;

}
