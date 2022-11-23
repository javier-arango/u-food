package com.api.ufood.config;

import com.api.ufood.model.user.Role;
import com.api.ufood.model.user.UserRoles;
import com.api.ufood.repository.RoleRepository;
import com.api.ufood.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);

        return modelMapper;
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository) {
        return args -> {
            //Create Admin and User Roles
            Role adminRole = roleRepository.findByRole(UserRoles.ADMIN);
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setRole(UserRoles.ADMIN);
                roleRepository.save(adminRole);
            }

            Role userRole = roleRepository.findByRole(UserRoles.USER);
            if (userRole == null) {
                userRole = new Role();
                userRole.setRole(UserRoles.USER);
                roleRepository.save(userRole);
            }
        };
    }

}
