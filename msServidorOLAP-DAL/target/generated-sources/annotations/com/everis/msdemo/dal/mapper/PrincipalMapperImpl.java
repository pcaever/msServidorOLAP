package com.everis.msdemo.dal.mapper;

import com.everis.msdemo.dal.dto.AdjuntoDTO;
import com.everis.msdemo.dal.dto.PrincipalDTO;
import com.everis.msdemo.dal.entity.Adjuntos;
import com.everis.msdemo.dal.entity.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-26T20:19:14-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.3.1100.v20200828-0941, environment: Java 14.0.2 (Oracle Corporation)"
)
public class PrincipalMapperImpl implements PrincipalMapper {

    @Override
    public Principal principalDTOToPrincipal(PrincipalDTO fasesDTO) {
        if ( fasesDTO == null ) {
            return null;
        }

        Principal principal = new Principal();

        principal.setAdjuntos( adjuntoDTOListToAdjuntosList( fasesDTO.getAdjuntos() ) );
        principal.setDireccion( fasesDTO.getDireccion() );
        principal.setId( fasesDTO.getId() );
        principal.setNombre( fasesDTO.getNombre() );
        principal.setObservaciones( fasesDTO.getObservaciones() );
        principal.setPaisId( fasesDTO.getPaisId() );
        principal.setTelefono( fasesDTO.getTelefono() );
        principal.setUsuarioActualiza( fasesDTO.getUsuarioActualiza() );
        principal.setUsuarioCrea( fasesDTO.getUsuarioCrea() );

        principal.setActivo( true );

        return principal;
    }

    @Override
    public PrincipalDTO principalToPrincipalDTO(Principal fases) {
        if ( fases == null ) {
            return null;
        }

        PrincipalDTO principalDTO = new PrincipalDTO();

        principalDTO.setAdjuntos( adjuntosListToAdjuntoDTOList( fases.getAdjuntos() ) );
        principalDTO.setDireccion( fases.getDireccion() );
        principalDTO.setId( fases.getId() );
        principalDTO.setNombre( fases.getNombre() );
        principalDTO.setObservaciones( fases.getObservaciones() );
        principalDTO.setPaisId( fases.getPaisId() );
        principalDTO.setTelefono( fases.getTelefono() );
        principalDTO.setUsuarioActualiza( fases.getUsuarioActualiza() );
        principalDTO.setUsuarioCrea( fases.getUsuarioCrea() );

        return principalDTO;
    }

    protected Adjuntos adjuntoDTOToAdjuntos(AdjuntoDTO adjuntoDTO) {
        if ( adjuntoDTO == null ) {
            return null;
        }

        Adjuntos adjuntos = new Adjuntos();

        adjuntos.setAdjuntoId( adjuntoDTO.getAdjuntoId() );
        adjuntos.setFechaActualizacion( adjuntoDTO.getFechaActualizacion() );
        adjuntos.setFechaCreacion( adjuntoDTO.getFechaCreacion() );
        adjuntos.setId( adjuntoDTO.getId() );
        adjuntos.setUsuarioActualiza( adjuntoDTO.getUsuarioActualiza() );
        adjuntos.setUsuarioCrea( adjuntoDTO.getUsuarioCrea() );

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

        adjuntoDTO.setAdjuntoId( adjuntos.getAdjuntoId() );
        adjuntoDTO.setFechaActualizacion( adjuntos.getFechaActualizacion() );
        adjuntoDTO.setFechaCreacion( adjuntos.getFechaCreacion() );
        adjuntoDTO.setId( adjuntos.getId() );
        adjuntoDTO.setUsuarioActualiza( adjuntos.getUsuarioActualiza() );
        adjuntoDTO.setUsuarioCrea( adjuntos.getUsuarioCrea() );

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
