package com.example.serve.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.serve.dto.TicketDTO;
import com.example.serve.entity.TicketEntity;
import com.example.serve.repository.TicketRepo;

@Service
public class TicketServiceImpl implements TicketService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TicketRepo repo;
	SimpleDateFormat dob = new SimpleDateFormat("dd/MM/yyyy");

	@Override
		public String validateAndAddTicket(TicketDTO dto) {
			try {
				if (!dto.getTicketType().equals(null) && !dto.getTicketType().equals("")) {
					if (dto.getQueriesType().equals(null) && dto.getQueriesType().equals(null)) {
						if (!dto.getDate().equals(null) && !dto.getDate().equals("")) {
							if (!dto.getQueries().equals(null) && !dto.getQueries().equals("")) {
								if (dto.getUserId() != 0 ) {
									if (!dto.getAgentId().equals(null) && !dto.getAgentId().equals("")) {
									if(!dto.getTechieId().equals(null) && !dto.getTechieId().equals("")) {
											if (!dto.getPriority().equals(null) && !dto.getPriority().equals("")) {
												if (!dto.getStatus().equals(null) && !dto.getStatus().equals("")) {
												
													    TicketEntity entity = new TicketEntity();
														Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDate());
														entity.setDate(date1);
														BeanUtils.copyProperties(dto, entity);
														logger.info(""+entity);
														repo.save(entity);
														logger.info("" + entity);
														return "Ticket added";
													} else {
														logger.error("Enter status");
														return "Enter status";
													}
												} else {
													logger.error("Enter priority");
													return "Enter priority";
												}
											} else {
												logger.error("Enter agent id");
												return "Enter agent id";
											}
										} else {
											logger.error("Enter user id");
											return "Enter user id";
										}
									} else {
										logger.error("Enter queries");
										return "Enter queries";
									}
								} else {
									logger.error("Enter date");
									return "Enter date";
								}
							} else {
								logger.error("Enter queries type");
								return "Enter queries type";
							}
						} else {
							logger.error("Enter ticket type");
							return "Enter ticket type";
						}
					 
				} else {
					logger.error("Enter ticket type");
					return "Enter ticket type";
				}
			}catch (Exception e) {
				logger.info(e.getMessage(), e.getClass().getName());
			}
			return null;
		}
    
    
    
    
    
    



	@Override
	public List<TicketDTO> validateAndGetAllTickets() {
		List<TicketDTO> tDto = new ArrayList<>();
    	List<TicketEntity> entities = repo.findAll();
    	logger.info(""+entities);
    	
    	try {
    		for (TicketEntity ticketEntity : entities) {
    			TicketDTO dto = new TicketDTO();
    			BeanUtils.copyProperties(ticketEntity, dto);
    			dto.setDate(dob.format(ticketEntity.getDate()));
    			tDto.add(dto);
    			logger.info("" +tDto);
    			logger.info(""+tDto);
			}
    		
    		
    	}catch(Exception e) {
    			logger.error(e.getMessage(),e.getClass().getName());
    		}
    	
    		return tDto;
	}

	@Override
	public String validateAndUpdateById(TicketDTO dto) {
		int id = dto.getUserId();
    	TicketEntity entity = repo.findByUserId(id);
    	Date UpdateDate = null;
    	
    	try {
    	if(entity !=null) {
    		if(dto.getTicketType()!=null)
    			entity.setTicketType(dto.getTicketType());
    	}
    		if(dto.getQueries()!=null) {
    			entity.setQueries(dto.getQueries());
    	}
            if(dto.getDate()!=null) {
            	UpdateDate = new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDate());
            	entity.setDate(UpdateDate);
            }
            if(dto.getQueries()!=null) {
    			entity.setQueries(dto.getQueries());
    	}
            
            if(dto.getAgentId()!=null) {
    			entity.setAgentId(dto.getAgentId());
    	}
            if(dto.getTechieId()!=null) {
    			entity.setTechieId(dto.getTechieId());
    	}
            
            if(dto.getPriority()!=null) {
    			entity.setPriority(dto.getPriority());
    	}
            if(dto.getStatus()!=null) {
    			entity.setStatus(dto.getStatus());
    			
    			repo.save(entity);
    			logger.info("" + entity);
    	}
            
}   catch(Exception e) {
	logger.error(e.getMessage(),e.getClass().getName());
}
return "Info updated";
		
	}
	

}
