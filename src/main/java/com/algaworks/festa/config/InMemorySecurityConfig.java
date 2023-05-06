package com.algaworks.festa.config;/* 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication
.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@Configuration
public class InMemorySecurityConfig {
@Autowired
public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
    builder
        .inMemoryAuthentication()
        .passwordEncoder(NoOpPasswordEncoder.getInstance())
        .withUser("joao").password("1234").roles("USER")
        .and()
        .withUser("alexandre").password("1234").roles("USER")
        .and()
        .withUser("thiago").password("1234").roles("USER")
        .and()
        .withUser("joely").password("1234").roles("USER");
}
}*/
/* 

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder)
throws Exception {
builder
.inMemoryAuthentication()
.withUser("joao").password("1234").roles("USER")
.and()
.withUser("alexandre").password("1234").roles("USER")
.and()
.withUser("thiago").password("1234").roles("USER")
.and()
.withUser("joely").password("1234").roles("USER");
}
}*/
