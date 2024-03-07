package org.sid.endPoint;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.sid.dto.ProfileDTO;
import org.sid.dto.ProfilePictureDTO;
import org.sid.entities.Profile;
import org.sid.services.ProfilePictureService;
import org.sid.services.ProfileServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    private ProfileServise profileServise;

    @Autowired
    private ProfilePictureService profilePictureService;
    @GetMapping("/list")
    public ResponseEntity<List<Profile>> all() {
      List<Profile> profiles =   profileServise.all();
        return ResponseEntity.ok(profiles);
    }

    @PostMapping("/add")
    public ResponseEntity<String> saveProfile(ProfileDTO profileDTO){
        profileServise.saveProfile(profileDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body("profile added successfully");
    }

    @PostMapping(value = "/picture", consumes = {"multipart/form-data"})
    public ResponseEntity<String> addPicture(@RequestParam("file") MultipartFile file, ProfilePictureDTO profilePictureDTO) throws FileUploadException {
        profilePictureService.addPicture(file, profilePictureDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body("picture added successfully");
    }
}
