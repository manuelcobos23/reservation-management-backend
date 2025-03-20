/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bookandgo.reservation")
public class Application {

	/**
	 * Main.
	 *
	 * @param args the args
	 */
	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
