package com.example.serve.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.serve.dto.TicketDTO;
import com.example.serve.entity.TicketEntity;
import com.example.serve.service.TicketService;

@RestController

public class TicketController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	TicketService service;
	@PostMapping("addTicket")
	String addTicket(@RequestBody TicketDTO dto)
	{
		String message=null;
		try {
			message=service.validateAndAddTicket(dto);
			
		} catch (Exception e) {
			logger.info(e.getMessage(),e.getClass().getName());
		}
		return message;
	}
	
	
	@GetMapping("getAllTickets")
	List<TicketDTO> getAllTickets()
	{
		List<TicketDTO> dto=null;
		try {
			dto=service.validateAndGetAllTickets();
		} catch (Exception e) {
			logger.info(e.getMessage(),e.getClass().getName());
		}
		return dto;
	}
	
	
	@PostMapping("updateTicket")
	String updateTicket(@RequestBody TicketDTO tDTO) {
		String msg = null;
		
		try {
			msg = service.validateAndUpdateById(tDTO);
		} catch(Exception e) {
			logger.error(e.getMessage(),e.getClass().getName());
		}
		return msg;
	}
	
}
