package com.own.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ViewConfiguration.class})
public class MvcConfig {

}
