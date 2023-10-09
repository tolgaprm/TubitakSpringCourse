package yte.intern.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        createUser();
    }

    private void createUser() throws Exception {
        UserDetails user = User.builder()
                .username("user")
                .password("user")
                .authorities("ROLE_USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("admin")
                .authorities("ROLE_ADMIN")
                .build();

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(user)
                .withUser(admin)
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
