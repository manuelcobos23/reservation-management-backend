/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Class to configure the persistence layer
 * @author manuelcobos66@gmail.com
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.bookandgo.reservation.infra.persistence.jpa" })
@EntityScan(basePackages = { "com.bookandgo.reservation.infra.persistence.jpa.entities" })
public class PersistenceConfig {

	// Empty
}
