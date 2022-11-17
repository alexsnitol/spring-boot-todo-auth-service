package com.example.directory.service;

import com.example.directory.domain.Person;
import com.example.directory.repository.PersonRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Alexander Slotin (<a href="https://github.com/alexsnitol">@alexsnitol</a>) <p>
 * 2022 Nov
 */
@Service
public class DirectoryUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;


    public DirectoryUserDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            final Person person = personRepository.findByEmailIgnoreCase(username);

            if (person != null) {
                return User
                        .withUsername(person.getEmail())
                        .password(person.getPassword())
                        .roles(person.getRole())
                        .accountLocked(!person.isEnabled())
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new UsernameNotFoundException("User with email " + username + " not found");
    }

}
