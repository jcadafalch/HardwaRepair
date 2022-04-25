package cat.copernic.HardwaRepair.Controller.AuthenticationConfig;

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
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                //URL i subURLS (**) on pot accedir...
                .antMatchers("/SelectModule", "/static/**")
                //...l'usuari amb rol admin
                .hasRole("admin")
                //URL inici on poden accedir...
                .antMatchers("/")
                //...l'usuari amb rol usuari
                .hasRole("usuari")
                .and()
                //Objecte que representa el formulari de login personalitzat que utilitzarem
                .formLogin()
                //Pàgina on es troba el formulari per fer login personalitzat
                .loginPage("/login")
                .defaultSuccessUrl("/inici", true)
                .and()
                //Mostrarem la pàgina error403 si l'usuari no té accés a una àgina o acció 
                .exceptionHandling().accessDeniedPage("/error/error403");
    }
}
