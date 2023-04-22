package id.co.bca.spring.NanoCustomer.config;

import id.co.bca.spring.NanoCustomer.service.MyUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){return new MyUserDetailService();}
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){return new BCryptPasswordEncoder();}
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/**").permitAll()
                .requestMatchers(HttpMethod.POST,"/**").permitAll()
                .requestMatchers(HttpMethod.PUT,"/**").permitAll()
                .requestMatchers(HttpMethod.DELETE,"/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
        return http.build();
    }
}
