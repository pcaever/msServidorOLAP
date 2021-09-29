package com.everis.msdemo.dal.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.msdemo.dal.dto.PrincipalDTO;

@RequestMapping("/principal")
public interface PrincipalController {
	@PostMapping("/")
	public PrincipalDTO save(@RequestBody PrincipalDTO fasesDTO);
}
