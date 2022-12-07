package com.flaze.stern.services;

import com.flaze.stern.models.firebase.FirebaseUser;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseUserService {

    public static final String COLLECTION_NAME = "users";

    public String saveUser(FirebaseUser firebaseUser) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(firebaseUser.getUid()).set(firebaseUser);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public FirebaseUser getUser(String uid) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(uid);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        FirebaseUser firebaseUser;
        if (document.exists()) {
            firebaseUser = document.toObject(FirebaseUser.class);
            return firebaseUser;
        } else {
            return null;
        }
    }

    public String updatePatientDetails(FirebaseUser firebaseUser) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(firebaseUser.getUid()).set(firebaseUser);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteUser(String uid) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COLLECTION_NAME).document(uid).delete();
        return "Document with User UID " + uid + " has been deleted: " + writeResult.get().getUpdateTime();
    }

}
