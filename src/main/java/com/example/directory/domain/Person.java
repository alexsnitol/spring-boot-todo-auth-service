package com.example.directory.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Alexander Slotin (<a href="https://github.com/alexsnitol">@alexsnitol</a>) <p>
 * 2022 Nov
 */
@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String email;
    private String name;
    private String password;
    private String role = "USER";
    private boolean enabled = true;
    private LocalDate birthday;

    @Column(updatable = false)
    private LocalDateTime created;
    private LocalDateTime modified;


    @PrePersist
    public void onCreate() {
        LocalDateTime currentDt = LocalDateTime.now();
        this.created = currentDt;
        this.modified = created;
    }

    @PreUpdate
    public void onUpdate() {
        this.modified = LocalDateTime.now();
    }

}
