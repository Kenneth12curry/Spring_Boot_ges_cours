package ism.ges_cours_planification_ism2023.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    UserDetailsService service;
    @Autowired
    PasswordEncoder passwordEncoder;
    /*
       @Bean
       public InMemoryUserDetailsManager userDetailsMemoiryManager(){
           UserDetails user= User.withDefaultPasswordEncoder()
                   .username("client")
                   .password("passer")
                   .roles("Client")
                   .build();
           UserDetails user1= User.withDefaultPasswordEncoder()
                   .username("admin")
                   .password("passer")
                   .roles("Client","Admin")
                   .build();
           return new InMemoryUserDetailsManager(user,user1);
       }

     */
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=
                new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(service);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.formLogin().defaultSuccessUrl("/liste-session-cours");
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests()
                .requestMatchers("/webjars/**").permitAll()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/api/**").permitAll()
                .requestMatchers("/professeur/**").hasAuthority("Professeur")
                .requestMatchers("/etudiant/**").hasAuthority("Etudiant")
                .requestMatchers("/rp/**").hasAuthority("RP")
                .requestMatchers("/ac/**").hasAuthority("AC")
                .anyRequest()
                .authenticated();
        http.exceptionHandling().accessDeniedPage("/403");
        return http.build();
    }

}
