package com.example.serve.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.serve.dto.UserDTO;
import com.example.serve.entity.UserEntity;
import com.example.serve.repository.UserRepository;
import com.example.serve.service.UserService;


@Service

public class UserServiceImpl implements UserService{

	 
	    @Autowired
	    private UserRepository userRepository;
	 
	    @Override
	    public UserEntity save(UserEntity user) {
	        return userRepository.save(user);
	    }
	 
	 
	    @Override
	    public Optional<UserEntity> findById(Long id) {
	        return userRepository.findById(id);
	    }
	 
	    @Override
	    public List<UserEntity> findAll() {
	        return userRepository.findAll();
	    }


		
	  


}
