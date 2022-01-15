package hua.WebApp.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.Base64;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    public AuthenticationProvider authProvider (){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(getPasswordEncoder());
        return provider;
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//           auth.userDetailsService(userDetailsService);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/requests").hasRole("STUDENT")
                .antMatchers("/addRequest").hasRole("STUDENT")
                .antMatchers("/editRequest").hasRole("STUDENT")
                .antMatchers("deleteRequest/{requestId}").hasRole("STUDENT")
                .antMatchers("/pendingRequests").hasRole("PROFESSOR")
                .antMatchers("/setRequestStatus").hasRole("PROFESSOR")
                .antMatchers("/addLetter").hasRole("PROFESSOR")
                .antMatchers("/editLetter/{letterId}").hasRole("PROFESSOR")
                .antMatchers("/deleteLetter/{letterId}").hasRole("PROFESSOR")
                .and().formLogin().and().csrf().disable();

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder;
    }
}
