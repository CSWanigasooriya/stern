package com.flaze.stern.controllers.firestore;

import com.flaze.stern.controllers.BaseController;
import com.flaze.stern.models.firestore.FirebaseUser;
import com.flaze.stern.services.FirebaseUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/firestore")
public class FirestoreUserController extends BaseController {
    final
    FirebaseUserService firebaseUserService;

    public FirestoreUserController(FirebaseUserService firebaseUserService) {
        this.firebaseUserService = firebaseUserService;
    }

    @GetMapping("/users")
    public List<FirebaseUser> getAllUsers() throws ExecutionException, InterruptedException {
        return firebaseUserService.getAllUsers();
    }

    @GetMapping("/user/{uid}")
    public FirebaseUser getUser(@PathVariable String uid) throws InterruptedException, ExecutionException {
        return firebaseUserService.getUser(uid);
    }

    @PostMapping("/user")
    public String createUser(@RequestBody FirebaseUser firebaseUser) throws InterruptedException, ExecutionException {
        return firebaseUserService.saveUser(firebaseUser);
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody FirebaseUser firebaseUser) throws InterruptedException, ExecutionException {
        return firebaseUserService.updatePatientDetails(firebaseUser);
    }

    @DeleteMapping("/user/{uid}")
    public String deleteUser(@PathVariable String uid) throws ExecutionException, InterruptedException {
        return firebaseUserService.deleteUser(uid);
    }
}
