package com.flaze.stern.services;

import com.flaze.stern.models.firestore.FirebaseUser;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class FirebaseUserService {

    public static final String COLLECTION_NAME = "users";

    public String saveUser(FirebaseUser firebaseUser) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COLLECTION_NAME).document(firebaseUser.getUid()).set(firebaseUser);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public List<FirebaseUser> getAllUsers() throws ExecutionException, InterruptedException {
        List<FirebaseUser> firebaseUsers = new ArrayList<>();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> query = dbFirestore.collection(COLLECTION_NAME).get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            FirebaseUser firebaseUser = document.toObject(FirebaseUser.class);
            firebaseUsers.add(firebaseUser);
        }
        return firebaseUsers;
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
