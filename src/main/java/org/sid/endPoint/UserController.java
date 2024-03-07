package org.sid.endPoint;

import org.sid.entities.UserEntity;
import org.sid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserEntity>> userList() {
        List<UserEntity> users = userService.userList();
        return ResponseEntity.ok(users);
    }
}
