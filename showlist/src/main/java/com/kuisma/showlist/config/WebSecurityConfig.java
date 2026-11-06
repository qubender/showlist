package com.kuisma.showlist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    @Bean 
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            //sivujen oikeudet
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/addshow/**", "/delete/**", "/edit/**", "/save/**").hasAuthority("ADMIN")
                .anyRequest().permitAll()
            )
                .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")
            )
            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin())
            )
            //sisäänkirjautuminen
            .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .defaultSuccessUrl("/showlist", false)
                .permitAll());
        
            return http.build();
    }

}
