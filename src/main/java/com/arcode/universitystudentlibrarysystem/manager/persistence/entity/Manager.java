package com.arcode.universitystudentlibrarysystem.manager.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "manager")
@Builder(toBuilder = true)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manager_id_seq")
    @SequenceGenerator(name = "manager_id_seq", sequenceName = "manager_id_seq", allocationSize = 1)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "day", nullable = false)
    private String birthDay;

}
