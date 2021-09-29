package com.everis.msdemo.be.mapper;

import org.mapstruct.Mapper;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface PrincipalMapper {/*
	PrincipalMapper INSTANCE = Mappers.getMapper(PrincipalMapper.class);

	@Mapping(source = "principalMainMSDTO.pais.id", target = "paisId")
	@Mapping(source = "adjuntos", target = "adjuntos")
	@Mapping(target = "usuarioCrea", source = "usuario")
    @Mapping(target = "usuarioActualiza", source = "usuario")
	PrincipalDTO principalMSDTOToPrincipalDTO(PrincipalMSDTO principalMainMSDTO, List<AdjuntoDTO> adjuntos, Integer usuario);
	
	@Mapping(target = "principal", source = "principal")
	PrincipalResponseMSDTO principalMSDTOToPrincipalResponseMSDTO(PrincipalMSDTO principal);*/
}
