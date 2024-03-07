package org.sid.services;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.sid.dto.ProfileDTO;
import org.sid.entities.Profile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProfileServise {
    void saveProfile(ProfileDTO profileDTO);
    List<Profile> all();


}
