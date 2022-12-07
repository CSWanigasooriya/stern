package com.flaze.stern.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;

@Service
public class FirebaseInitialize {
    final ResourceLoader resourceLoader;

    public FirebaseInitialize(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void initialize() {
        try {
            Resource resource = resourceLoader.getResource("classpath:static/sync-vote-firebase-adminsdk-1ej20-f2c1095069.json");
            File file = new File(resource.getFile().toURI());
            InputStream serviceAccount = resource.getInputStream();
            FirebaseOptions options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl("https://sync-vote-default-rtdb.asia-southeast1.firebasedatabase.app").build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
