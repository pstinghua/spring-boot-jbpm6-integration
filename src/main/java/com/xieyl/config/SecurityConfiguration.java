package com.xieyl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author xieyuanliang
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration extends GlobalMethodSecurityConfiguration {
    @Autowired
    private UserDetailsService userDetailsService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth
            .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
//            .inMemoryAuthentication()
//                .withUser("admin").password("1").roles("ADMIN");
        // @formatter:one
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @EnableWebMvcSecurity
    public static class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    }
}
