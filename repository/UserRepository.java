package com.example.serve.repository;
	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.serve.entity.UserEntity;

@Repository
			public interface UserRepository extends JpaRepository<UserEntity, Long>{

		
		}
		

