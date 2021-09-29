package com.everis.msdemo.dal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.everis.msdemo.dal.dto.PrincipalDTO;
import com.everis.msdemo.dal.service.PrincipalService;

@RestController
public class PrincipalControllerImpl implements PrincipalController {

	@Autowired
	private PrincipalService principalService;

	public PrincipalDTO save(PrincipalDTO fasesDTO) {
		return principalService.save(fasesDTO);
	}	
}
