package org.example.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Builder
@Table(name = "users")
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone_number;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
