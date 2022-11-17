package com.example.directory.repository;

import com.example.directory.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Alexander Slotin (<a href="https://github.com/alexsnitol">@alexsnitol</a>) <p>
 * 2022 Nov
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmailIgnoreCase(@Param("email") String email);

}
