package com.everis.msServidorOLAP.be.controller;

import com.everis.msServidorOLAP.be.constant.ConstantMsg;
import com.everis.msServidorOLAP.be.dto.DetalleCubo2DTO;
import com.everis.msServidorOLAP.be.dto.ResponseDTO;
import com.everis.msServidorOLAP.be.exception.SiecaException;
import com.everis.msServidorOLAP.be.service.CuboBeDalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class CuboBeDalControllerImpl extends HandleErrorControllerImpl implements CuboBeDalController{

    @Autowired
    CuboBeDalService cuboBeDalService;

    @Override
    public String sluado() {
        return "Hola soy controller CuboDal";
    }

    @Override
    public ResponseDTO endPoint1() throws SiecaException {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse(cuboBeDalService.findAllCubos());
        responseDTO.getError().setCodError(ConstantMsg.CODE_200);
        responseDTO.getError().setMessError(ConstantMsg.ERROR_200);

        return responseDTO;
    }

    @Override
    public ResponseDTO endPoint2(String cubo) throws SiecaException {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse(cuboBeDalService.findByheader(cubo));
        responseDTO.getError().setCodError(ConstantMsg.CODE_200);
        responseDTO.getError().setMessError(ConstantMsg.ERROR_200);

        return responseDTO;
    }

    @Override
    public ResponseDTO endPoint3( @Valid DetalleCubo2DTO beDalDetalleCuboDTO) throws SiecaException {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse(cuboBeDalService.crearSelect(beDalDetalleCuboDTO));
        responseDTO.getError().setCodError(ConstantMsg.CODE_200);
        responseDTO.getError().setMessError(ConstantMsg.ERROR_200);
        return responseDTO;
    }
}
