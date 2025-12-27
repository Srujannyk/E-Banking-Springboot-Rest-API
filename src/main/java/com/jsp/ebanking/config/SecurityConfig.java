package com.jsp.ebanking.config;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private String[] swaggerPaths = { "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/webjars/**" };
	
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173","http://127.0.0.1:5503/","https://checkout.razorpay.com", "https://ebanking-x7l5.onrender.com"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain security(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(x -> x.disable())
				.authorizeHttpRequests(x -> x.requestMatchers("/api/v1/auth/**").permitAll()
						.requestMatchers(swaggerPaths).permitAll().anyRequest().authenticated())
				.formLogin(x -> x.disable()).httpBasic(x -> x.disable())
				.sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
	}
}
