/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bookandgo.reservation.Application;
import com.bookandgo.reservation.domain.repository.ApplicablePriceRepository;
import com.bookandgo.reservation.domain.service.ApplicablePriceService;
import com.bookandgo.reservation.domain.service.impl.ApplicablePriceServiceImpl;

/**
 * Class to configure Domain beans to use
 * 
 * @author manuelcobos66@gmail.com
 *
 */
@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BeanConfiguration {

    @Bean
    ApplicablePriceService applicablePriceService(final ApplicablePriceRepository applicablePriceRepository) {
        return new ApplicablePriceServiceImpl(applicablePriceRepository);
    }
}
