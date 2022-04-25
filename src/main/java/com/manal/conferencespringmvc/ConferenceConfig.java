package com.manal.conferencespringmvc;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
public class ConferenceConfig implements WebMvcConfigurer {

//  @Autowired
//  private ApplicationContext applicationContext;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/files/**")
        .addResourceLocations("/WEB-INF/pdf/");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }

  @Bean
  public LocaleResolver localeResolver() {
    SessionLocaleResolver slr = new SessionLocaleResolver();
    slr.setDefaultLocale(Locale.US);
    return slr;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    lci.setParamName("lang");
    return lci;
  }

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver bean = new InternalResourceViewResolver();
    bean.setPrefix("/WEB-INF/jsp/");
    bean.setSuffix(".jsp");
    //changed this to 0 again, to fix JSP functionality and get it running without
    // having to change anything
    bean.setOrder(0);
    return bean;
  }

//  @Bean
//  public ViewResolver thymeleafResolver(){
//    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//    viewResolver.setTemplateEngine(templateEngine());
//    viewResolver.setOrder(1);
//    return viewResolver;
//  }

// //templateResolver looks up the actual template
//  @Bean
//  public SpringResourceTemplateResolver templateResolver() {
//    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//    templateResolver.setApplicationContext(applicationContext);
//    templateResolver.setPrefix("/WEB-INF/views/");
//    templateResolver.setSuffix(".html");
//    return templateResolver;
//  }

//  @Bean
//  public SpringTemplateEngine templateEngine() {
//    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//    templateEngine.setTemplateResolver(templateResolver());
//    //enabling the SpEL compiler, so we can use the shorthand syntax
//    // of accessing Spring variables and passing them in
//    templateEngine.setEnableSpringELCompiler(true);
//    return templateEngine;
//  }

}
