package com.flaze.stern.models.firebase;

import lombok.Data;

@Data
public class FirebaseUser {
    private String uid;
    private String email;
    private String displayName;
    private String photoURL;
    private String phoneNumber;
    private boolean emailVerified;
    private String providerId;
}
