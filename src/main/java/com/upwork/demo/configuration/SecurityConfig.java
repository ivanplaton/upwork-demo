package com.upwork.demo.configuration;

import com.upwork.demo.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final DataSource dataSource;

    public SecurityConfig(
            CustomUserDetailsService customUserDetailsService,
            DataSource dataSource
    ) {
        this.customUserDetailsService = customUserDetailsService;
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> {
                csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
                csrf.csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler());
            })
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "api/v1/feedback").permitAll()
                .anyRequest().authenticated()
            )
            .userDetailsService(customUserDetailsService)
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/welcome", true)
                .permitAll()
            )
            .rememberMe(rememberMe -> rememberMe
                .key("upworkdemo123")
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(86400)
                .rememberMeCookieName("upwork-demo-cookie")
            );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        List<String> allowedHeaders = List.of(
                "Origin",
                "Accept",
                "X-Requested-With",
                "Content-Type",
                "Cache-Control",
                "X-XSRF-TOKEN"
        );

        List<String> allowedMethods = List.of(
                "GET",
                "POST",
                "PUT",
                "DELETE"
        );

        List<String> allowedOrigins = List.of(
                "*"
        );

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(allowedHeaders);
        configuration.setAllowedMethods(allowedMethods);
        configuration.setAllowedOrigins(allowedOrigins);
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
