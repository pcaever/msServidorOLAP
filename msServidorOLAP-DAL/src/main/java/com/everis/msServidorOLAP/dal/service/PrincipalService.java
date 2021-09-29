package com.everis.msdemo.dal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.everis.msdemo.dal.dto.PrincipalDTO;
import com.everis.msdemo.dal.entity.Principal;
import com.everis.msdemo.dal.mapper.PrincipalMapper;
import com.everis.msdemo.dal.repository.PrincipalRepository;

@Service
public class PrincipalService {

	@Autowired
	private PrincipalRepository principalRepository;

	public PrincipalService(PrincipalRepository encabezadosRepository) {
		this.principalRepository = encabezadosRepository;
	}

	@Transactional
	public PrincipalDTO save(PrincipalDTO principalDTO) {
		principalRepository.updatePrincipalPresave(principalDTO.getNombre());
		Principal principal = principalRepository.save(PrincipalMapper.INSTANCE.principalDTOToPrincipal(principalDTO));
		return PrincipalMapper.INSTANCE.principalToPrincipalDTO(principal);
	}
}
