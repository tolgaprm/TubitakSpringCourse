package yte.intern.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        createUser();
    }

    private void createUser() throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserDetails userDetails = User.builder()
                .username("Tolga")
                .password(passwordEncoder.encode("123456"))
                .authorities("ROLE_USER")
                .build();

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(userDetails)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/hello")).hasRole("ROLE_USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .build();
    }
}
