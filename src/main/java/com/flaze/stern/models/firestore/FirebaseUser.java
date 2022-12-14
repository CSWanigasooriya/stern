package com.flaze.stern.models.firestore;

import lombok.Data;

import java.util.ArrayList;

@Data
public class FirebaseUser {
    private String uid;
    private String email;
    private String displayName;
    private String photoURL;
    private String phoneNumber;
    private boolean emailVerified;
    private String providerId;

    private boolean isAnonymous;

    private String tenantId;

    private ArrayList<UserInfo> providerData;

    private String refreshToken;
}


@Data
class UserInfo {
    private String uid;
    private String displayName;
    private String email;
    private String phoneNumber;
    private String photoURL;
    private String providerId;
}