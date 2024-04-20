package com.jwt.security.Appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class config {
    @Bean
    public UserDetailsService userDetailsService() {
        System.out.println("varification of shikhar");
        UserDetails userDetails = User.builder().
                username("shikhar")
                .password(passwordEncoder().encode("gupta")).roles("ADMIN").
                build();
        System.out.println("end of varification of shikhar");
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("inside password encoder");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        System.out.println("inside AuthenticationManager");
        return builder.getAuthenticationManager();
    }
}
