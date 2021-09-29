package com.everis.msServidorOLAP.be.controller;

import com.everis.msServidorOLAP.be.dto.DetalleCubo2DTO;
import com.everis.msServidorOLAP.be.dto.ResponseDTO;
import com.everis.msServidorOLAP.be.exception.SiecaException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cuboBeDal")
public interface CuboBeDalController {

    @GetMapping("/")
    public String sluado();

    @GetMapping(path= "/all")
    public ResponseDTO endPoint1() throws SiecaException;

    @GetMapping(path= "/detalle",produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO endPoint2( @RequestHeader("cubo") String cubo) throws SiecaException;

    @PostMapping(path= "/consultaSQL",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO endPoint3(@RequestBody DetalleCubo2DTO beDalDetalleCuboDTO) throws SiecaException;


}
