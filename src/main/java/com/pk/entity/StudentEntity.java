package com.pk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENT_DETAILS")
public class StudentEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    private int age;
}
