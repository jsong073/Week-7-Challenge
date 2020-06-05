package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityJdbcDataSource {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJdbcDataSource.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository userRepository, RoleRepository roleRepository) throws Exception {
        return (String[] args) -> {
            User admin = new User("admin", "admin@domain.com", "admin", "Admin",
                    "Admin", true);
            Role adminRole = new Role("admin", "ROLE_ADMIN");
            userRepository.save(admin);
            roleRepository.save(adminRole);
        };
    }
}
