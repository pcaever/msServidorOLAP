package com.everis.msServidorOLAP.be.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface AdjuntosMapper {
    AdjuntosMapper INSTANCE = Mappers.getMapper(AdjuntosMapper.class);

    /*@Mapping(target = "nombre", source = "documento.nombreDocumento")
    @Mapping(target = "usuarioCreacion", source = "usuario")
    @Mapping(target = "usuarioActualizacion", source = "usuario")
    @Mapping(target = "id", expression = "java(null)")
    DocumentosDTO documentosMSDTOToDocumentosDTO(DocumentosMSDTO documento, UserDTO usuario);
    
    @Mapping(target = "nombreDocumento", source = "nombre")
    DocumentosMSDTO documentosDTOToDocumentosMSDTO(DocumentosDTO documentosDTO);
    
    List<DocumentosMSDTO> listDocumentosDTOToListDocumentosMSDTO(List<DocumentosDTO> listDocumentosDTO);
    
    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "adjuntoId", source = "documentosDTO.id")
    @Mapping(target = "usuarioCrea", source = "usuario")
    @Mapping(target = "usuarioActualiza", source = "usuario")
    AdjuntoDTO documentosDTOToAdjuntoDTO(DocumentosDTO documentosDTO, Integer usuario);*/
}
