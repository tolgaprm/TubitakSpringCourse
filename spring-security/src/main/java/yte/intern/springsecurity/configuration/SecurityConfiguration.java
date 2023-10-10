package yte.intern.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import yte.intern.springsecurity.customAuth.CustomAuthenticationProvider;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {
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

        //  authenticationManagerBuilder
        //        .authenticationProvider(customAuthenticationProvider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .csrf(csrf -> csrf.disable())
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(CustomAuthenticationProvider customAuthenticationProvider) {
        return new ProviderManager(customAuthenticationProvider);
    }
}
