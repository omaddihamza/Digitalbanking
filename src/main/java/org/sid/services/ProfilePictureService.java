package org.sid.services;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.sid.dto.ProfilePictureDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ProfilePictureService {
    void addPicture(MultipartFile file, ProfilePictureDTO profilePictureDTO) throws FileUploadException;
}
