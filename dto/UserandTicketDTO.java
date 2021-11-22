package com.example.serve.dto;

import java.util.Date;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor

public class UserandTicketDTO {
	private String TicketType;
	private String ticketId;
	private String date;
	private String QueriesType;
	private String queries;
	private String status;
	private String priority;
	private String AgentId;
	private String TechieId;
	private int userId;
	private String firstName;
	private String lastName;
	private String designation;
	private float salary;
	private long contact;
	private String email;
	private String country;
	private String gender;
	private String address;
	
	
}
