package com.flaze.stern.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    private String uid;
    private String displayName;
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    private String photoUrl;
    private String providerId;
}