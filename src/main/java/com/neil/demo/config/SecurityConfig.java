package com.neil.demo.config;

import com.neil.demo.service.UserSecurityService;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;



@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.database.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired
    //private Environment env;

    @Autowired
    private UserSecurityService userSecurityService;




    private BCryptPasswordEncoder passwordEncode() {
        return SecurityUtility.passwordEncoder();
    }

    private static final String[] PUBLIC_MATCHES = {
            "/css/**", "/js/**", "/image/**", "/book/**", "/user/**"
    };


    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests().antMatchers(PUBLIC_MATCHES).permitAll().anyRequest().authenticated();
    }


    @Autowired
    public void  configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncode());
    }

    @Bean
    public HttpSessionStrategy httpSessionStrategy(){

        return new HeaderHttpSessionStrategy() ;
    }

}


