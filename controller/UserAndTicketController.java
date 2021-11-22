package com.example.serve.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.serve.dto.TicketDTO;
import com.example.serve.dto.UserandTicketDTO;
import com.example.serve.service.UserAndTicketService;

@RestController
public class UserAndTicketController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	
	UserAndTicketService userandTicketService;
	@GetMapping("allTickets")
	List<UserandTicketDTO> allTickets(){
	List<UserandTicketDTO> userandTicketDTOS=null;
		try {
			userandTicketDTOS=userandTicketService.getallTickets();
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return userandTicketDTOS;
	}
	
	
	
	@GetMapping("userTickets")
	List<UserandTicketDTO> userTickets(@RequestParam int userId){
	List<UserandTicketDTO> userandTicketDTOS=null;
		try {
			userandTicketDTOS=userandTicketService.getUserTickets(userId);
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return userandTicketDTOS;
	}
	

}
