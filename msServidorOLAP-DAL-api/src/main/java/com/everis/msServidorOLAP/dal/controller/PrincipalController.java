package com.everis.msServidorOLAP.dal.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.msServidorOLAP.dal.dto.PrincipalDTO;

@RequestMapping("/principal")
public interface PrincipalController {
	@PostMapping("/")
	public PrincipalDTO save(@RequestBody PrincipalDTO fasesDTO);
}
