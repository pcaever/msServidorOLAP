package com.everis.msdemo.be.service;

import com.everis.msdemo.be.constant.ConstantMsg;
import com.everis.msdemo.be.dto.*;
import com.everis.msdemo.be.exception.SiecaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class CuboBeDalService {

    private static Logger LOG = LoggerFactory.getLogger(CuboBeDalService.class);
    /**
     * Método findAll
     *
     * @param
     * @retur lista de cubos
     * */
     public List<CuboDTO> findAllCubos(){
         log.debug("findAllCubo");
    //llamado al servicio
         LOG.info("llamado al microservicio que retorna la consulta de all");


         LOG.info("Retornando un listado de todos los cubos");
         return  null;
     }
    /**
     * Método findByheader
     *
     * @param cubo
     * @retur lista de cubos
     * */
     public List<BeDalDetalleCuboDTO> findByheader(String cubo) throws SiecaException {


         if (cubo == null) {
             throw new SiecaException(ConstantMsg.CODE_460,
                     String.format(ConstantMsg.CODE_460, "Cubo"));
         }
         LOG.info("llamado al microservicio que retorna la consulta por detalle con el request header "+cubo);

         LOG.info("listado de cubos retornando a la peticion");
         return null;
     }

    /**
     * Método crearSelect
     *
     * @param beDalDetalleCuboDTO
     * @retur lista de cubos
     * */
     public int crearSelect(DetalleCubo2DTO beDalDetalleCuboDTO) {

         //LOG.info(beDalDetalleCuboDTO.getCubo());
         //paso1 recibir json
         StringBuilder strSQL = new StringBuilder("SELECT");
         int i = 1;

         int c = 1;

        if(beDalDetalleCuboDTO.getDimensiones()!=null){

            Iterator<BeDalDetalleCuboDimension2DTO>ListDimensiones=
                    Arrays.asList(beDalDetalleCuboDTO.getDimensiones()).iterator();

            int sizelistDime = Arrays.asList(beDalDetalleCuboDTO.getDimensiones()).size();

            while (ListDimensiones.hasNext()) {

                String strValores;

                BeDalDetalleCuboDimension2DTO dimension= ListDimensiones.next();

                String nombreDimension =dimension.getNombre();

                //LOG.info(dimension.getNombre());

                if(dimension.getValores()!=null){
                    Iterator<DetalleCuboDimensionValor2DTO>listValores=
                            Arrays.asList(dimension.getValores()).iterator();

                    int sizeListValores = Arrays.asList(dimension.getValores()).size();

                    while(listValores.hasNext()){

                        DetalleCuboDimensionValor2DTO valor = listValores.next();

                        strValores ="{ [" + nombreDimension
                                + "].[" + valor.getValor() + "].[" + valor.getLlave() + "].CHILDREN} ON COLUMNS";

                        strSQL.append(strValores);

                        if (c != sizeListValores && i != sizelistDime) {
                            strSQL.append(",");
                        }
                    }
                    c++;
                }

                i++;
            }

            strSQL.append(" FROM [dw_sieca_pdcc].[dwh].[Fact_AgentesAduaneros_AFPA]");

        }
         LOG.info(strSQL.toString());

        ConsultaSqlSelectDTO consultaSqlSelectDTO = new ConsultaSqlSelectDTO();

        consultaSqlSelectDTO.setConsultaSql(strSQL.toString());
         LOG.info("Se usa el microservico del Dal para el envio de consulta  Sql en un JSON");

         LOG.info("se recibe la respuesta de Microservicio");

         LOG.info("queda pendiente como va ser el response");

         return 0;
     }



}
