/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.Controller.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author jcadafalch
 */
@Configuration
@EnableWebSecurity
public class ConfiguracióAutenticacio extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDatailService;

    @Autowired
    public void autenticacio(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDatailService).passwordEncoder(new BCryptPasswordEncoder());
    };
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/formulariGos"/*, "/editar/**", "/eliminar/**"*/) //URL i subURLS (**) on pot accedir...
                .hasRole("admin") //...l'usuari amb rol veterinari
                .antMatchers("/") //URL inici on poden accedir...
                .hasAnyRole("admin", "usuari") //...els usuaris amb rol veterinari i pacient
                .and()
                .formLogin() //Objecte que representa el formulari de login personalitzat que utilitzarem
                .loginPage("/login") //Pàgina on es troba el formulari per fer login personalitzat
                .and()
                .exceptionHandling().accessDeniedPage("/error/error403"); //Mostrarem la pàgina error403 si l'usuari no té accés a una àgina o acció 
    }
}
    