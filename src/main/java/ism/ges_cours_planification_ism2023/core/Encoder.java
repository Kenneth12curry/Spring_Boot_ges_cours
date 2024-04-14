package ism.ges_cours_planification_ism2023.core;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encoder {
    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
}
