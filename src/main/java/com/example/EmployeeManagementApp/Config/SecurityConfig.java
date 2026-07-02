package com.example.EmployeeManagementApp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder)
//    {
//        UserDetails admin= User.builder()
//                .username("admin")
//                .password(encoder.encode("admin1234"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user= User.builder()
//                .username("user")
//                .password(encoder.encode("user1234"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
//        http.csrf(csrf->csrf.disable())
//                .authorizeHttpRequests(auth->auth
//                        .requestMatchers(HttpMethod.GET,"/employees/**").permitAll().anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();

        http.csrf((csrf->csrf.disable()))
                .authorizeHttpRequests(auth->auth
                        .requestMatchers(HttpMethod.POST,"/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET,"/employees/**")
                        .hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.POST,"/employees").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/employees/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());;
        return http.build();
    }
}
