/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringData.SpringData.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author fernan
 */
@Configuration
@EnableWebSecurity
//clase para configurar los usuarios que se van a utilizar
public class SecuritySpring extends WebSecurityConfigurerAdapter{
//    metodo para agregar mas usuarios y configurarlos para hacer login el la aplicacion
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth){
//        try {
//              auth.inMemoryAuthentication().withUser("admin")
//                    .password("{noop}135")
//                    .roles("ADMIN","USER")
//                    .and()
//                    .withUser("user")
//                    .password("{noop}1356").roles("USER");
//        } catch (Exception e) {
//        }
//    } 
    
    @Autowired
    private UserDetailsService uds;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build){
        try {
             build.userDetailsService(uds).passwordEncoder(passwordEncoder());
        } catch (Exception e) {
        }
    }
    
      //metodo para autorizacion de los usuarios, que pueden hacer
    @Override
    protected void configure(HttpSecurity http){
        try {
             http.authorizeRequests().antMatchers("/editar/**", "/agregar/**","/eliminar" ).hasRole("ADMIN")
                .antMatchers("/").hasAnyRole("ADMIN","USER")
                     .and()
                     .formLogin()
                     .loginPage("/login").and()
                     .exceptionHandling().accessDeniedPage("/errores/403");
        } catch (Exception e) {
        }
       
    }
}
