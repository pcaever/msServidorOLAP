package com.everis.msServidorOLAP.be.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.everis.msServidorOLAP.be.constant.ConstantMsg;
import com.everis.msServidorOLAP.be.dto.MensajesErrorDTO;
import com.everis.msServidorOLAP.be.exception.SiecaException;

@Service
public class AdicionalService {

	@Value("${ws.backend.url.usersDAL}")
	private String urlUsersDAL;

	@Value("${ws.backend.url.parametrizacionDAL}")
	private String urlParametrizacionDAL;

	@Value("${ws.backend.url.trazabilidadDAL}")
	private String urlTrazabilidadDAL;

	@Value("${ws.backend.url.adjuntosBE}")
	private String urlAdjuntosBE;

	@Value("${ws.backend.get.countries.path}")
	private String getCountriesPath;

	@Value("${ws.backend.get.errores.codigo.path}")
	private String getMensajeErrorPath;

	@Value("${ws.backend.get.trazabilidad.estados.path}")
	private String getEstadoFuncionalidad;

	@Value("${ws.backend.get.ids.adjunto.path}")
	private String getAdjuntoBase64Path;

	@Value("${ws.backend.save.adjunto.path}")
	private String saveAdjuntoBase64Path;

	@Value("${ws.backend.get.parametros.tipo.path}")
	private String getParametrosTipoPath;

	
	private RestTemplate restTemplate = new RestTemplate();
	private static Logger logger = LoggerFactory.getLogger(AdicionalService.class);
	
	static final String FORMAT_URL_3 = "%s%s%s";

	public MensajesErrorDTO getMensajeError(String codigoError, List<Object> argumentos) {
		MensajesErrorDTO mensajeError = getMensajeError(codigoError);
		
		if (argumentos != null) {
			mensajeError.setMensajeError(String.format(mensajeError.getMensajeError(), argumentos.toArray(new Object[0])));
		}
		
		return mensajeError;
	}

	public MensajesErrorDTO getMensajeError(String codigoError) {
		ResponseEntity<MensajesErrorDTO> mensajeError = restTemplate.exchange(
				String.format(FORMAT_URL_3, urlParametrizacionDAL, getMensajeErrorPath, codigoError), HttpMethod.GET, null,
				MensajesErrorDTO.class);
		
		if (mensajeError.getBody() != null) {
			return mensajeError.getBody();
		} else {
			return new MensajesErrorDTO(ConstantMsg.CODE_OFFLINE, String.format(ConstantMsg.ERROR_OFFLINE, codigoError)); 
		}
	}

	public SiecaException generarMensajeException(String codigoError) {
		return generarMensajeException(codigoError, null);
	}

	public SiecaException generarMensajeException(String codigoError, List<Object> argumentos) {
		MensajesErrorDTO mensajeError = getMensajeError(codigoError);
		
		if (argumentos == null) {
			return new SiecaException(mensajeError.getCodigoError(), mensajeError.getMensajeError());
		} else {
			return new SiecaException(mensajeError.getCodigoError(), String.format(mensajeError.getMensajeError(), argumentos.toArray(new Object[0])));
		}
	}
	
	/*public List<GenericDTO> getCountries() {
		ResponseEntity<List<GenericDTO>> listCountriesResponse = restTemplate.exchange(
				String.format("%s%s", urlUsersDAL, getCountriesPath), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<GenericDTO>>() { });

		List<GenericDTO> listCountries = listCountriesResponse.getBody();

		if (listCountries != null && !listCountries.isEmpty()) {
			listCountries.forEach(foreachDT -> foreachDT.setCode(foreachDT.getCode().replaceAll("([GU]{2})", "GT")));
			return listCountries;
		} else {
			return Collections.emptyList();
		}
	}

	public List<EstadosDTO> getEstados(String codigoFuncionalidad) throws SiecaException {
		ResponseEntity<List<EstadosDTO>> findAll = restTemplate.exchange(String.format(FORMAT_URL_3, urlTrazabilidadDAL, getEstadoFuncionalidad, codigoFuncionalidad),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<EstadosDTO>>() { });

		List<EstadosDTO> estados = findAll.getBody();

		if (estados != null) {
			return estados;
		} else {
			throw generarMensajeException(ConstantMsg.CODE_440G, Arrays.asList(codigoFuncionalidad));
		}
	}
	
	public List<ParametrosDTO> getParametrosByTipo(String tipo) {
		ResponseEntity<List<ParametrosDTO>> listParametrosResponse = restTemplate.exchange(
				String.format(FORMAT_URL_3, urlParametrizacionDAL, getParametrosTipoPath, tipo), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ParametrosDTO>>() {
				});

		List<ParametrosDTO> listParametros = listParametrosResponse.getBody();
		if (listParametros != null && !listParametros.isEmpty()) {
			return listParametros;
		} else {
			return Collections.emptyList();
		}
	}

	public List<DocumentosDTO> getAdjuntosBase64(String idsAdjuntos) throws SiecaException {
		try {
			ResponseEntity<ResponseAdjuntoDTO> findAdjuntos = restTemplate.exchange(
					String.format(FORMAT_URL_3, urlAdjuntosBE, getAdjuntoBase64Path, idsAdjuntos),
					HttpMethod.GET, null, new ParameterizedTypeReference<ResponseAdjuntoDTO>() { });
	
			ResponseAdjuntoDTO responseAdjuntoDTO = findAdjuntos.getBody();
	
			if (responseAdjuntoDTO != null && responseAdjuntoDTO.getResponse() != null) {
				return responseAdjuntoDTO.getResponse();
			} else {
				throw generarMensajeException(ConstantMsg.CODE_460);
			}
		} catch (Exception ex) {
			generateUUID(ex);
			throw generarMensajeException(ConstantMsg.CODE_460);
		}
	}

	public List<DocumentosDTO> saveAdjuntosBase64(List<DocumentosDTO> listaAdjuntos) throws SiecaException {
		List<DocumentosDTO> saveAdjuntosList = new ArrayList<>();
		
		try {
			if (listaAdjuntos == null || listaAdjuntos.isEmpty()) {
				return Collections.emptyList();
			}
	
			for (DocumentosDTO adjuntosMSDTO : listaAdjuntos) {
				HttpEntity<DocumentosDTO> entity = new HttpEntity<>(adjuntosMSDTO, setHeadersSave());
				ResponseEntity<ResponseSaveAdjuntoDTO> adjuntoResponseDTO = restTemplate.exchange(
						String.format("%s%s", urlAdjuntosBE, saveAdjuntoBase64Path), HttpMethod.POST, entity,
						ResponseSaveAdjuntoDTO.class);
	
				ResponseSaveAdjuntoDTO responseAdjuntoDTO = adjuntoResponseDTO.getBody();
	
				if (responseAdjuntoDTO != null && responseAdjuntoDTO.getResponse() != null) {
					saveAdjuntosList.add(responseAdjuntoDTO.getResponse());
				} else {
					throw generarMensajeException(ConstantMsg.CODE_461);
				}
			}
		} catch (Exception ex) {
			generateUUID(ex);
			throw generarMensajeException(ConstantMsg.CODE_461);
		}

		return saveAdjuntosList;
	}

	private HttpHeaders setHeadersSave() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json; charset=UTF-8");
		return headers;
	}
	
	public ParametrosDTO setParametro(List<ParametrosDTO> parametros, ParametrosDTO entidadParametro, String variableMensaje) throws SiecaException {
    	entidadParametro = getParametroByCodigo(parametros, entidadParametro.getCodigo());
    	
    	if (entidadParametro == null) {
    		throw generarMensajeException(ConstantMsg.CODE_481, Arrays.asList(variableMensaje));
    	}
    	
    	return entidadParametro;
    }
	
	public GenericDTO setGeneric(List<GenericDTO> listaGeneric, GenericDTO entidadGeneric, String variableMensaje) throws SiecaException {
    	entidadGeneric = getGenericByCodigo(listaGeneric, entidadGeneric.getCode());
    	
    	if (entidadGeneric == null) {
    		throw generarMensajeException(ConstantMsg.CODE_481, Arrays.asList(variableMensaje));
    	}
    	
    	return entidadGeneric;
    }
    
    public EstadosDTO setEstado(List<EstadosDTO> listaEstados, EstadosDTO entidadEstado, String variableMensaje) throws SiecaException {
    	entidadEstado = getEstadoByCodigo(listaEstados, entidadEstado.getCodigo());
    	
    	if (entidadEstado == null) {
    		throw generarMensajeException(ConstantMsg.CODE_481, Arrays.asList(variableMensaje));
    	}
    	
    	return entidadEstado;
    }
    
    public ParametrosDTO getParametroByCodigo(List<ParametrosDTO> parametros, String codigo) {
    	return parametros.stream().filter(filterParametro -> filterParametro.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
    
    public GenericDTO getGenericByCodigo(List<GenericDTO> listGeneric, String code) {
    	return listGeneric.stream().filter(filterParametro -> filterParametro.getCode().equals(code)).findFirst().orElse(null);
    }
    
    public EstadosDTO getEstadoByCodigo(List<EstadosDTO> listaEstados, String codigo) {
    	return listaEstados.stream().filter(filterParametro -> filterParametro.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
    
    public EstadosDTO getEstadoById(List<EstadosDTO> listaEstados, Integer idEstado) {
    	return listaEstados.stream().filter(filterParametro -> filterParametro.getId().equals(idEstado)).findFirst().orElse(null);
    }
    
    public String generateUUID(Object exception) {
		String uuidError = java.util.UUID.randomUUID().toString();
		logger.info(uuidError, exception);
		return uuidError;
	}
    
    public void validateDTO(Object entityValidate) throws SiecaException, MethodArgumentNotValidException {
		MethodParameter methodParameter = null;
		try {
			Method methodGetErrorValidation = this.getClass().getMethod("validateDTO", Object.class);
			HandlerMethod handlerMethod = new HandlerMethod(this, methodGetErrorValidation);
			methodParameter = handlerMethod.getReturnType();
		} catch (NoSuchMethodException e) {
			throw new SiecaException("SiecaException", "Invalid method validateDTO(Object)");
		}
		
		MethodArgumentNotValidException errorArgument = validateEntity(methodParameter, entityValidate, entityValidate.getClass().getName());
		
		if (!CollectionUtils.isEmpty(errorArgument.getBindingResult().getAllErrors())) {
			throw errorArgument;
		}
	}

	public MethodArgumentNotValidException validateEntity(MethodParameter methodParameter, Object entityValidate, String className) {
		Map<String, String> mapErrors = new HashMap<>();
		BindingResult errors = new MapBindingResult(mapErrors, className);
		LocalValidatorFactoryBean validatorModels = new LocalValidatorFactoryBean();
		validatorModels.afterPropertiesSet();
		validatorModels.validate(entityValidate, errors);
		validatorModels.close();
		return new MethodArgumentNotValidException(methodParameter, errors);
	}*/
}