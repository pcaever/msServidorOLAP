package com.everis.msServidorOLAP.dal.mapper;

import com.everis.msServidorOLAP.dal.dto.AdjuntoDTO;
import com.everis.msServidorOLAP.dal.dto.PrincipalDTO;
import com.everis.msServidorOLAP.dal.entity.Adjuntos;
import com.everis.msServidorOLAP.dal.entity.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-29T11:46:52-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
public class PrincipalMapperImpl implements PrincipalMapper {

    @Override
    public Principal principalDTOToPrincipal(PrincipalDTO fasesDTO) {
        if ( fasesDTO == null ) {
            return null;
        }

        Principal principal = new Principal();

        principal.setId( fasesDTO.getId() );
        principal.setNombre( fasesDTO.getNombre() );
        principal.setDireccion( fasesDTO.getDireccion() );
        principal.setTelefono( fasesDTO.getTelefono() );
        principal.setObservaciones( fasesDTO.getObservaciones() );
        principal.setPaisId( fasesDTO.getPaisId() );
        principal.setUsuarioCrea( fasesDTO.getUsuarioCrea() );
        principal.setUsuarioActualiza( fasesDTO.getUsuarioActualiza() );
        principal.setAdjuntos( adjuntoDTOListToAdjuntosList( fasesDTO.getAdjuntos() ) );

        principal.setActivo( true );

        return principal;
    }

    @Override
    public PrincipalDTO principalToPrincipalDTO(Principal fases) {
        if ( fases == null ) {
            return null;
        }

        PrincipalDTO principalDTO = new PrincipalDTO();

        principalDTO.setId( fases.getId() );
        principalDTO.setNombre( fases.getNombre() );
        principalDTO.setDireccion( fases.getDireccion() );
        principalDTO.setTelefono( fases.getTelefono() );
        principalDTO.setObservaciones( fases.getObservaciones() );
        principalDTO.setPaisId( fases.getPaisId() );
        principalDTO.setUsuarioCrea( fases.getUsuarioCrea() );
        principalDTO.setUsuarioActualiza( fases.getUsuarioActualiza() );
        principalDTO.setAdjuntos( adjuntosListToAdjuntoDTOList( fases.getAdjuntos() ) );

        return principalDTO;
    }

    protected Adjuntos adjuntoDTOToAdjuntos(AdjuntoDTO adjuntoDTO) {
        if ( adjuntoDTO == null ) {
            return null;
        }

        Adjuntos adjuntos = new Adjuntos();

        adjuntos.setId( adjuntoDTO.getId() );
        adjuntos.setAdjuntoId( adjuntoDTO.getAdjuntoId() );
        adjuntos.setFechaCreacion( adjuntoDTO.getFechaCreacion() );
        adjuntos.setFechaActualizacion( adjuntoDTO.getFechaActualizacion() );
        adjuntos.setUsuarioCrea( adjuntoDTO.getUsuarioCrea() );
        adjuntos.setUsuarioActualiza( adjuntoDTO.getUsuarioActualiza() );

        return adjuntos;
    }

    protected List<Adjuntos> adjuntoDTOListToAdjuntosList(List<AdjuntoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Adjuntos> list1 = new ArrayList<Adjuntos>( list.size() );
        for ( AdjuntoDTO adjuntoDTO : list ) {
            list1.add( adjuntoDTOToAdjuntos( adjuntoDTO ) );
        }

        return list1;
    }

    protected AdjuntoDTO adjuntosToAdjuntoDTO(Adjuntos adjuntos) {
        if ( adjuntos == null ) {
            return null;
        }

        AdjuntoDTO adjuntoDTO = new AdjuntoDTO();

        adjuntoDTO.setId( adjuntos.getId() );
        adjuntoDTO.setAdjuntoId( adjuntos.getAdjuntoId() );
        adjuntoDTO.setFechaCreacion( adjuntos.getFechaCreacion() );
        adjuntoDTO.setFechaActualizacion( adjuntos.getFechaActualizacion() );
        adjuntoDTO.setUsuarioCrea( adjuntos.getUsuarioCrea() );
        adjuntoDTO.setUsuarioActualiza( adjuntos.getUsuarioActualiza() );

        return adjuntoDTO;
    }

    protected List<AdjuntoDTO> adjuntosListToAdjuntoDTOList(List<Adjuntos> list) {
        if ( list == null ) {
            return null;
        }

        List<AdjuntoDTO> list1 = new ArrayList<AdjuntoDTO>( list.size() );
        for ( Adjuntos adjuntos : list ) {
            list1.add( adjuntosToAdjuntoDTO( adjuntos ) );
        }

        return list1;
    }
}
