package com.example.serve.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.serve.dto.TicketDTO;

@Service
public interface TicketService {

List<TicketDTO> validateAndGetAllTickets();
String validateAndAddTicket(TicketDTO dto);
String validateAndUpdateById(TicketDTO tDTO);

}
