package com.example.serve.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.serve.dto.TicketDTO;
import com.example.serve.dto.UserandTicketDTO;
import com.example.serve.entity.TicketEntity;
import com.example.serve.entity.UserAndTicketEntity;
import com.example.serve.entity.UserEntity;
import com.example.serve.repository.TicketRepo;
import com.example.serve.repository.UserAndTicketRepository;

@Service
public class UserAndTicketServiceImpl implements UserAndTicketService{
	@Autowired
	UserAndTicketRepository userAndTicketRepo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public String mappingUserAndTicket(UserEntity userEntity, TicketEntity ticketEntity) {
		
		try {
			UserAndTicketEntity userAndTicketEntity = new UserAndTicketEntity();
			BeanUtils.copyProperties(ticketEntity, userAndTicketEntity);
			BeanUtils.copyProperties(userEntity, userAndTicketEntity);
			userAndTicketRepo.save(userAndTicketEntity);
			logger.info("" + userAndTicketEntity);
			logger.info("saved");
		
	}  catch(NullPointerException | TypeMismatchException e) {
		logger.error(e.getMessage(),e.getClass().getSimpleName());
	}
return "saved successfully";
	}
	

	
	@Override
	
	public String updateMapping(TicketEntity ticketEntity) {
		UserAndTicketEntity userAndTicketEntity = (UserAndTicketEntity) userAndTicketRepo.findById(ticketEntity.getTicketid());
		
		try {
			if(userAndTicketEntity!=null) {
				BeanUtils.copyProperties(ticketEntity, userAndTicketEntity);	
				userAndTicketRepo.save(userAndTicketEntity);
				logger.info("" + userAndTicketEntity);
				logger.info("updated");
			    return "updated successfully";
			}   
			} 
		        catch(NullPointerException | TypeMismatchException e) {
				logger.error(e.getMessage(),e.getClass().getSimpleName());
			}
		return null;
		}
	
	
	
	@Override
	
	public List<UserAndTicketEntity> updateUserMapping(UserEntity userEntity) {
		List<UserAndTicketEntity> userAndTicketEntity = userAndTicketRepo.findByuserId(userEntity.getUserId());
		
		//findByUserId(userEntity.getUserId());
		List<UserAndTicketEntity> userAndTicketEntities = new ArrayList<>();
		
		try {
			if(userAndTicketEntity!=null) {
				logger.info("a"+userEntity);
				
				for(UserAndTicketEntity userandTicketEntity2 : userAndTicketEntity) {
					BeanUtils.copyProperties(userEntity, userandTicketEntity2);
					logger.info("" + userandTicketEntity2);
					userAndTicketEntities.add(userandTicketEntity2);
					logger.info("" + userAndTicketEntities + "\n");
					logger.info("Mapping saved");
					
				}
				
				userAndTicketRepo.saveAll(userAndTicketEntities);
				logger.info("" + userAndTicketEntities);
				
				
			}
		} catch(NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
	return userAndTicketEntity;
	}
	
	
		
	/*	try {
			if(userAndTicketEntity!=null) {
				BeanUtils.copyProperties(ticketEntity, userAndTicketEntity);	
				userAndTicketRepo.save(userAndTicketEntity);
				logger.info("" + userAndTicketEntity);
				logger.info("updated");
			    return "updated successfully";
			}   
			} 
		        catch(NullPointerException | TypeMismatchException e) {
				logger.error(e.getMessage(),e.getClass().getSimpleName());
			}
		return null;
		}
	
	*/
	
	
	
	@Override
	
	public List<UserandTicketDTO> getallTickets() {
	List<UserandTicketDTO> userAndTicketDTOs = new ArrayList<>();
	
	try {
		List<UserAndTicketEntity> userAndTicketEntities = userAndTicketRepo.findAll();
		UserandTicketDTO userAndTicketDTO = new UserandTicketDTO();
	
		for(UserAndTicketEntity userAndTicketEntity : userAndTicketEntities) {
			BeanUtils.copyProperties(userAndTicketEntity, userAndTicketDTO);
			userAndTicketDTOs.add(userAndTicketDTO);
		}	
		} catch(NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(),e.getClass().getName());
		}
	return userAndTicketDTOs;
	}
	
	
	
	@Override
	
	public List<UserandTicketDTO> getUserTickets(int userId) {
	List<UserandTicketDTO> userAndTicketDTOs = new ArrayList<>();
	
	try {
		List<UserAndTicketEntity> userAndTicketEntities = userAndTicketRepo.findByuserId(userId);
		UserandTicketDTO userAndTicketDTO = new UserandTicketDTO();
	
		for(UserAndTicketEntity userAndTicketEntity : userAndTicketEntities) {
			BeanUtils.copyProperties(userAndTicketEntity, userAndTicketDTO);
			userAndTicketDTOs.add(userAndTicketDTO);
		}	
		} catch(NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(),e.getClass().getName());
		}
	return userAndTicketDTOs;
	}
	
	
	
	
	
	
	
}
