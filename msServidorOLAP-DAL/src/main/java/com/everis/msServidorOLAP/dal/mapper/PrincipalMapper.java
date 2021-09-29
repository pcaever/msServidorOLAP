package com.everis.msServidorOLAP.dal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.everis.msServidorOLAP.dal.dto.PrincipalDTO;
import com.everis.msServidorOLAP.dal.entity.Principal;

@Mapper
public interface PrincipalMapper {
	PrincipalMapper INSTANCE = Mappers.getMapper(PrincipalMapper.class);

	@Mapping(target = "activo", constant = "true")
	Principal principalDTOToPrincipal(PrincipalDTO fasesDTO);

	PrincipalDTO principalToPrincipalDTO(Principal fases);
}