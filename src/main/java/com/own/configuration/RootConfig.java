package com.own.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({DataAccessConfiguration.class,MessageConfiguration.class})
@ImportResource({"/WEB-INF/spring/appServlet/security-context.xml"})
@ComponentScan(basePackages = {"com.own","com.pg"})
public class RootConfig {

}
