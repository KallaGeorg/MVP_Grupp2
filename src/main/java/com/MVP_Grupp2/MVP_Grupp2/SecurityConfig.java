package com.MVP_Grupp2.MVP_Grupp2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests((authorize) -> authorize
                .requestMatchers("/customer/register").permitAll()
                .requestMatchers("/customer/login").permitAll()
                .requestMatchers("/customer/{customerNumber}").permitAll()
                .requestMatchers("/api/products/men/bottom").permitAll()
                .requestMatchers("/api/products/woman/bottom").permitAll()
                .requestMatchers("/api/products/men/top").permitAll()
                .requestMatchers("/api/products/woman/top").permitAll()
                .requestMatchers("/api/products/woman/shoes").permitAll()
                .requestMatchers("/api/products/men/shoes").permitAll()
                .requestMatchers("/create-checkout-session").permitAll()
                .anyRequest().authenticated()

            )
            .httpBasic(withDefaults())
            .cors(withDefaults())
            .csrf((csrf) -> csrf.disable());
        return http.build();
    }
}