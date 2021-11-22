package com.example.serve.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.serve.dto.UserandTicketDTO;
import com.example.serve.entity.TicketEntity;
import com.example.serve.entity.UserAndTicketEntity;
import com.example.serve.entity.UserEntity;

@Service
public interface UserAndTicketService {

	String mappingUserAndTicket(UserEntity userEntity, TicketEntity ticketEntity);

	List<UserandTicketDTO> getallTickets();

	List<UserandTicketDTO> getUserTickets(int userId);

	String updateMapping(TicketEntity ticketEntity);

	List<UserAndTicketEntity> updateUserMapping(UserEntity userEntity);

	

}
