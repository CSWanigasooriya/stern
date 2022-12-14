package com.flaze.stern.dto;

import lombok.Data;

@Data
public class FirebaseUserDTO {
    private String uid;
    private String email;
    private String displayName;
    private String photoURL;
    private String phoneNumber;
}
