package com.everis.msdemo.be.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AdicionalServiceTest {

   /* @InjectMocks
    private AdicionalService adicionalService;

    @Value("${ws.backend.url.eGoveris}")
    private String urleGoveris;

    @Value("${ws.backend.url.sieca}")
    private String urlSieca;

    @Value("${ws.backend.get.documenttype.path}")
    private String getDocumentTypePath;

    @Value("${ws.backend.get.countries.path}")
    private String getCountriesPath;

    @Value("${ws.backend.get.parametros.tipo.path}")
    private String getParametrosTipoPath;

    @Value("${ws.backend.get.parametros.id.path}")
    private String getParametrosIdPath;

    @Value("${ws.backend.url.trazabilidadDAL}")
    private String urlDAL;

    @Value("${ws.backend.get.trazabilidad.estados.path}")
    private String getEstadoFuncionalidad;

    @Value("${ws.backend.url.adjuntos}")
    private String urlAdjuntos;

    @Value("${ws.backend.get.ids.adjunto.path}")
    private String getAdjuntoBase64Path;

    @Value("${ws.backend.save.adjunto.path}")
    private String saveAdjuntoBase64Path;


    /** The rest template. */

/*
    @Mock
    private RestTemplate restTemplate = new RestTemplate();

    static final String FORMAT_URL_3 = "%s%s%s";
    static final String VUCE057 = "VUCE057";

    List<GenericDTO> genericDTOList;
    GenericDTO genericDTO;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        genericDTOList = new ArrayList<>();
        genericDTO = new GenericDTO();

    }

    @AfterEach
    void tearDown() {
        genericDTOList = null;
        genericDTO = null;
    }

    @Test
    void testgetCountry(){

        ResponseEntity<List<GenericDTO>> findByCountries = new ResponseEntity<List<GenericDTO>>(new ArrayList<GenericDTO>(), HttpStatus.ACCEPTED);

        Mockito.when(restTemplate.exchange(Mockito.eq(String.format("%s%s", urleGoveris, getCountriesPath)),
                Mockito.eq(HttpMethod.GET), Mockito.eq(null),
                Mockito.<ParameterizedTypeReference<List<GenericDTO>>>any())).thenReturn(findByCountries);

            assertNotNull(adicionalService.getCountries());

    }

    @Test
    void testgetCountryfull(){

        List<GenericDTO> genericDTOList = new ArrayList<>();
        GenericDTO genericDTO = new GenericDTO();
        genericDTO.setCode("0");
        genericDTO.setDescription("0");
        genericDTO.setId(0);

        genericDTOList.add(genericDTO);
        ResponseEntity<List<GenericDTO>> findByCountries = new ResponseEntity<>(genericDTOList, HttpStatus.ACCEPTED);

        Mockito.when(restTemplate.exchange(Mockito.eq(String.format("%s%s", urleGoveris, getCountriesPath)),
                Mockito.eq(HttpMethod.GET), Mockito.eq(null),
                Mockito.<ParameterizedTypeReference<List<GenericDTO>>>any())).thenReturn(findByCountries);

        assertNotNull(adicionalService.getCountries());

    }

    @Test
    void testgetAdjuntosBase64(){

        String idsAdjuntos = "test";
        ResponseAdjuntoDTO responseAdjuntoDTO = new ResponseAdjuntoDTO();
        ErrorDTO error = new ErrorDTO();
        error.setCodError("200");
        responseAdjuntoDTO.setResponse(new ArrayList<>());
        ResponseEntity<ResponseAdjuntoDTO> findByCountries = new ResponseEntity<>(responseAdjuntoDTO, HttpStatus.ACCEPTED);


        Mockito.when(restTemplate.exchange(
                Mockito.eq(String.format(FORMAT_URL_3, urlAdjuntos, getAdjuntoBase64Path, idsAdjuntos)),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<ParameterizedTypeReference<ResponseAdjuntoDTO>>any()))
                .thenReturn(findByCountries);

        try {
            assertNotNull(adicionalService.getAdjuntosBase64(idsAdjuntos));
        } catch (Exception e) {
            assertNull(e.getMessage());
        }

    }


    @Test
    void testgetAdjuntosBase64Throw(){

        String idsAdjuntos = "test";
        ResponseAdjuntoDTO responseAdjuntoDTO = new ResponseAdjuntoDTO();
        ResponseEntity<ResponseAdjuntoDTO> findByCountries = new ResponseEntity<>(responseAdjuntoDTO, HttpStatus.ACCEPTED);


        Mockito.when(restTemplate.exchange(
                Mockito.eq(String.format(FORMAT_URL_3, urlAdjuntos, getAdjuntoBase64Path, idsAdjuntos)),
                Mockito.eq(HttpMethod.GET),
                Mockito.eq(null),
                Mockito.<ParameterizedTypeReference<ResponseAdjuntoDTO>>any()))
                .thenReturn(findByCountries);

        try {
            assertNotNull(adicionalService.getAdjuntosBase64(idsAdjuntos));
        } catch (Exception e) {
            assertNull(e.getMessage());
        }

    }

    @Test
    void testsaveAdjuntosBase64(){

        DocumentosDTO documentoMSDTO = new DocumentosDTO();
        documentoMSDTO.setNombre("0");
        documentoMSDTO.setId(0);
        documentoMSDTO.setFechaActualizacion(new Date());
        documentoMSDTO.setFechaCreacion(new Date());
        documentoMSDTO.setUsuarioActualizacion(new UserDTO());
        documentoMSDTO.setUsuarioCreacion(new UserDTO());

        ResponseSaveAdjuntoDTO saveAdjuntoDTO = new ResponseSaveAdjuntoDTO();
        ErrorDTO error = new ErrorDTO();
        error.setCodError("200");
        saveAdjuntoDTO.setResponse(documentoMSDTO);
        ResponseEntity<ResponseSaveAdjuntoDTO> tResponseEntity = new ResponseEntity<>(saveAdjuntoDTO, HttpStatus.ACCEPTED);

        List<DocumentosDTO> documentoMSDTOS = new ArrayList<>();
        documentoMSDTOS.add(documentoMSDTO);


        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=UTF-8");
        HttpEntity<DocumentosDTO> entity = new HttpEntity<>(documentoMSDTO, headers);


        Mockito.when(restTemplate.exchange(
                Mockito.eq(String.format("%s%s", urlAdjuntos, saveAdjuntoBase64Path)),
                Mockito.eq(HttpMethod.POST),
                Mockito.eq(entity),
                Mockito.<ParameterizedTypeReference<ResponseSaveAdjuntoDTO>>any()))
                .thenReturn(tResponseEntity);

        restTemplate.exchange(String.format("%s%s", urlAdjuntos, saveAdjuntoBase64Path),
                HttpMethod.POST, entity, ResponseSaveAdjuntoDTO.class);

        try {
            assertNotNull(adicionalService.saveAdjuntosBase64(documentoMSDTOS));
        } catch (Exception e) {
            assertNull(e.getMessage());
        }

    }
    */



}
