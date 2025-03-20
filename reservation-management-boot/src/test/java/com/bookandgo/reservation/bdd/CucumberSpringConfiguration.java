/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.bdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;

/**
 * Base class for StepsDef classes
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class CucumberSpringConfiguration {
	
	@Value("${app.api-rest.base-path}")
	protected String basePath;
	
	@Value("${spring.security.user.name}")
    protected String user;
	
	@Value("${spring.security.user.password}")
    protected String password;
	
	protected HttpHeaders headers;

	@Autowired
    protected TestRestTemplate testRestTemplate;
}
