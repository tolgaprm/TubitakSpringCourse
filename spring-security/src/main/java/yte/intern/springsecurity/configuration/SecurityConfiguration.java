package yte.intern.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import yte.intern.springsecurity.customAuth.CustomDetailsService;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final CustomDetailsService customDetailsService;

    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder, CustomDetailsService customDetailsService) throws Exception {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.customDetailsService = customDetailsService;
        createUser();
    }

    private void createUser() throws Exception {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("user")
//                .authorities("ROLE_USER")
//                .build();
//
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("admin")
//                .authorities("ROLE_ADMIN")
//                .build();

        authenticationManagerBuilder
                .userDetailsService(customDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .build();
    }
}
