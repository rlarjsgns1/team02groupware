package com.team02.groupware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team02.groupware.mapper.MessengerMapper;

@Service
@Transactional
public class MessengerService {
	
	@Autowired
	private MessengerMapper messengerMapper;

}
