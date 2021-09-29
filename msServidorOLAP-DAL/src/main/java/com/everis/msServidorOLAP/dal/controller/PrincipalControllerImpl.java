package com.everis.msServidorOLAP.dal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.everis.msServidorOLAP.dal.dto.PrincipalDTO;
import com.everis.msServidorOLAP.dal.service.PrincipalService;

@RestController
public class PrincipalControllerImpl implements PrincipalController {

	@Autowired
	private PrincipalService principalService;

	public PrincipalDTO save(PrincipalDTO fasesDTO) {
		return principalService.save(fasesDTO);
	}	
}
