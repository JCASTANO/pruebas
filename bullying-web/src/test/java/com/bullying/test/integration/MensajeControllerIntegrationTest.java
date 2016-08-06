//package com.bullying.test.integration;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.ResourceBundle;
//
//import jdk.nashorn.internal.ir.annotations.Ignore;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.IntegrationTest;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.TestRestTemplate;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.web.client.RestTemplate;
//
//import com.bullying.Application;
//import com.bullying.model.Mensaje;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
//@IntegrationTest("server.port=9000")
//public class MensajeControllerIntegrationTest {
//
//	private static final String CONTENIDO_MENSAJE = "Contenido";
//	private ResourceBundle aplicationBundle = ResourceBundle.getBundle("application");
//	private ResourceBundle urlBundle = ResourceBundle.getBundle("url");
//	private RestTemplate restTemplate = new TestRestTemplate(aplicationBundle.getString("security.user.name"), 
//															 aplicationBundle.getString("security.user.password"));
//    
//    @Test
//    @Ignore
//    public void procesarMensajeTest() {
//        Mensaje mensajeParaGuardar = new Mensaje();
//        mensajeParaGuardar.setId(1L);
//        mensajeParaGuardar.setContenido(CONTENIDO_MENSAJE);
//        Mensaje mensajeGuardado = restTemplate.postForObject(urlBundle.getString("guardar"), mensajeParaGuardar, Mensaje.class);
//        assertThat(mensajeGuardado.getContenido()).isEqualTo(CONTENIDO_MENSAJE);
//        assertThat(mensajeGuardado.getId()).isNotNull();
//        
//        Mensaje mensajeConsultado = restTemplate.getForObject(urlBundle.getString("buscarPorId"),Mensaje.class,mensajeGuardado.getId());
//        assertThat(mensajeConsultado.getContenido()).isEqualTo(CONTENIDO_MENSAJE);
//        assertThat(mensajeConsultado.getId()).isEqualTo(mensajeGuardado.getId());
//        
//        restTemplate.postForLocation(urlBundle.getString("borrar"), mensajeConsultado);
//        
//        Mensaje mensajeBorrado = restTemplate.getForObject(urlBundle.getString("buscarPorId"),Mensaje.class,mensajeConsultado.getId());
//        assertThat(mensajeBorrado).isEqualTo(null);
//    }
//}
