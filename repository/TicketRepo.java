package com.example.serve.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.example.serve.entity.TicketEntity;
@Repository
public interface TicketRepo extends JpaRepositoryImplementation<TicketEntity,Integer>{

	TicketEntity findByUserId(int id);
	

}
