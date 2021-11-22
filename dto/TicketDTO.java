package com.example.serve.dto;


	import java.util.Date;


import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;


	@Getter
	@Setter
	@NoArgsConstructor
	public class TicketDTO {
		private int ticketId;
		private int UserId;
	
		private String TicketType;
		private String date;
		private String QueriesType;
		private String queries;
		private String status;
		private String priority;
		private String AgentId;
		private String TechieId;
	
		
		
		}
