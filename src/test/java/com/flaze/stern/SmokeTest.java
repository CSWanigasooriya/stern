package com.flaze.stern;

import com.flaze.stern.controllers.firestore.FirestoreUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private FirestoreUserController firestoreUserController;

    @Test
    public void contextLoads(){
        assertThat(firestoreUserController).isNotNull();
    }
}