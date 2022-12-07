package com.flaze.stern.controllers;

import com.flaze.stern.models.firebase.FirebaseUser;
import com.flaze.stern.services.FirebaseUserService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class FirebaseUserController extends BaseController {
    final
    FirebaseUserService firebaseUserService;

    public FirebaseUserController(FirebaseUserService firebaseUserService) {
        this.firebaseUserService = firebaseUserService;
    }

    @GetMapping("/getUser/{uid}")
    public FirebaseUser getUser(@PathVariable String uid) throws InterruptedException, ExecutionException{
        return firebaseUserService.getUser(uid);
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody FirebaseUser firebaseUser) throws InterruptedException, ExecutionException {
        return firebaseUserService.saveUser(firebaseUser);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody FirebaseUser firebaseUser) throws InterruptedException, ExecutionException {
        return firebaseUserService.updatePatientDetails(firebaseUser);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam String uid) throws ExecutionException, InterruptedException {
        return firebaseUserService.deleteUser(uid);
    }
}
