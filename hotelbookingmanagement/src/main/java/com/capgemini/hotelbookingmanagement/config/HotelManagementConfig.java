package com.capgemini.hotelbookingmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class HotelManagementConfig {

	@Bean
	public LocalEntityManagerFactoryBean getEMF() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("hotelmanagementpersistence");
		return factoryBean;
	}// end of the getEMF()

}// end of the HotelManagementConfig class
