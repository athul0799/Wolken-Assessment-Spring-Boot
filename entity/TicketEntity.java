package com.example.serve.entity;


	import java.util.Date;

import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.GeneratedValue;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;
	import lombok.ToString;

	import org.hibernate.annotations.GenericGenerator;

	@Getter
	@Setter
	@NoArgsConstructor
	@Entity
	@ToString
	public class TicketEntity {
		
		@Id
		@GenericGenerator(name = "ticket" , strategy="increment")
		@GeneratedValue(generator="ticket")
		private int ticketid;
		private int userId;
	
		private String TicketType;
		private Date date;
		private String QueriesType;
		private String queries;
		private String status;
		private String priority;
		private String AgentId;
		private String TechieId;
		
		
		
		
		
		
		
		
		

	}
