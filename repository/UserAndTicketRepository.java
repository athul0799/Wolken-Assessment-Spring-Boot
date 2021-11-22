package com.example.serve.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.example.serve.entity.UserAndTicketEntity;

@Repository
public interface UserAndTicketRepository extends JpaRepositoryImplementation<UserAndTicketEntity, Integer> {
	
	UserAndTicketRepository findById(int ticketId);
	List<UserAndTicketEntity> findByuserId(int userId);


}
