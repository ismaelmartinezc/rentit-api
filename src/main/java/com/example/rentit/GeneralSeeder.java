package com.example.rentit;

import com.example.rentit.models.Role;
import com.example.rentit.models.User;
import com.example.rentit.repositories.RoleRepository;
import com.example.rentit.repositories.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class GeneralSeeder {
    @Bean
    CommandLineRunner initDatabase() {
        RoleRepository role;
        UserRepository user;
        
        return args -> {
            log.info("Generating basic roles...");
            role.save(new Role("Usuario", true));
            role.save(new Role("Moderador", true));
            role.save(new Role("Administrador", true));
            log.info("Roles were generated");

            log.info("Creating Admin...");
            user.save(
                new User(
                    "ismael.martinez@outlook.cl",
                    "Ismael",
                    "Martinez",
                    "membrillo",
                    true
                    //RoleRepository.findByName("Administrador")
                )
            );
        };
    }
}