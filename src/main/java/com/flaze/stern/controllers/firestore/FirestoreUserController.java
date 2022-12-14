package com.flaze.stern.controllers.firestore;

import com.flaze.stern.controllers.BaseController;
import com.flaze.stern.models.firestore.FirebaseUser;
import com.flaze.stern.services.FirebaseUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/firestore")
public class FirestoreUserController extends BaseController {
    final FirebaseUserService firebaseUserService;

    public FirestoreUserController(FirebaseUserService firebaseUserService) {
        this.firebaseUserService = firebaseUserService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<FirebaseUser>> getAll() throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(firebaseUserService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<FirebaseUser> getById(@PathVariable String uid) throws InterruptedException, ExecutionException {
        return new ResponseEntity<>(firebaseUserService.getUser(uid), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<String> save(@RequestBody FirebaseUser firebaseUser) throws InterruptedException, ExecutionException {
        return new ResponseEntity<>(firebaseUserService.saveUser(firebaseUser), HttpStatus.CREATED);
    }

    @PutMapping("/user")
    public ResponseEntity<String> update(@RequestBody FirebaseUser firebaseUser) throws InterruptedException, ExecutionException {
        return new ResponseEntity<>(firebaseUserService.updatePatientDetails(firebaseUser), HttpStatus.OK);
    }

    @DeleteMapping("/user/{uid}")
    public ResponseEntity<String> delete(@PathVariable String uid) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(firebaseUserService.deleteUser(uid), HttpStatus.OK);
    }
}
