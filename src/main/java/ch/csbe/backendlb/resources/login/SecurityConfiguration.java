package ch.csbe.backendlb.resources.login;

import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuration class for defining security rules and filters.
 */
@Configuration
public class SecurityConfiguration {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    /**
     * Define security rules and filters for the application.
     *
     * @param http The HttpSecurity object to configure security settings.
     * @return A SecurityFilterChain for processing security rules.
     * @throws Exception If an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Add the JWT request filter before the UsernamePasswordAuthenticationFilter
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        // Configure security settings
        http.csrf().disable();
        http
                .httpBasic().disable()
                .authorizeHttpRequests((authz) -> authz
                        // Permit public access to specific endpoints
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/demo/open").permitAll()
                        .requestMatchers("/swagger-ui/index.html").permitAll()
                        .requestMatchers("/user/{id}/promote").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/swagger-ui/*").permitAll()
                        .requestMatchers("/v3/api-docs").permitAll()
                        .requestMatchers("/user/{id}").permitAll()
                        .requestMatchers("/products").permitAll()
                        .requestMatchers("/products/{id}").permitAll()
                        .requestMatchers("/productscategories/{id}").permitAll()
                        .requestMatchers("/productscategories").permitAll()
                        .requestMatchers("productscategories/{name}/products").permitAll()
                        .requestMatchers("/v3/api-docs/swagger-config").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
