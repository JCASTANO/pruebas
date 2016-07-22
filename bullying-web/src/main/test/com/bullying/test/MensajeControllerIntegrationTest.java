package com.bullying.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ResourceBundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.bullying.dto.Mensaje;
import com.bullyng.services.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class MensajeControllerIntegrationTest {

	private ResourceBundle aplicationBundle = ResourceBundle.getBundle("application");
	private RestTemplate restTemplate = new TestRestTemplate(aplicationBundle.getString("security.user.name"), 
															 aplicationBundle.getString("security.user.password"));

    @Test
    public void getMensajeTest() {
        ResponseEntity<Mensaje> entity = restTemplate.getForEntity("http://localhost:9000/api/mensajeCtrl/getMensaje", Mensaje.class);
        assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(entity.getBody().getContenido()).isEqualTo(Mensaje.HOLA_MUNDO);
    }
    
    @Test
    public void saveMensajeTest() {
        Mensaje mensaje = new Mensaje();
        mensaje.setContenido(Mensaje.HOLA_MUNDO);
        Mensaje mensajeRespuesta = restTemplate.postForObject("http://localhost:9000/api/mensajeCtrl/saveMensaje", mensaje, Mensaje.class);
        assertThat(mensajeRespuesta.getContenido()).isEqualTo(Mensaje.HOLA_MUNDO);
        assertThat(mensajeRespuesta.getId()).isEqualTo(1L);
    }
}
