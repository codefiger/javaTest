package com.figer.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.util.regex.Pattern;

/**
 * Created by figer on 26/04/2017.
 */

@Configuration
@PropertySource("classpath:my.properties")
//@PropertySource("classpath:config.yml")
@ComponentScan(basePackages = "com.figer.spring.configuration")
public class MyConfig {
  @Bean
  public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
    PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
    return c;
  }

  //To inject complex properties using @Value annotation you need to use the following code
  @Bean
  public static ConversionService conversionService() {
    DefaultFormattingConversionService cs = new DefaultFormattingConversionService();

    cs.addConverter(String.class, Pattern.class, Pattern::compile);
    return cs;
  }
}
