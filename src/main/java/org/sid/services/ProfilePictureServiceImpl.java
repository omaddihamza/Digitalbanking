package org.sid.services;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.modelmapper.ModelMapper;
import org.sid.dto.ProfilePictureDTO;
import org.sid.entities.ProfilePicture;
import org.sid.repository.ProfilePictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ProfilePictureServiceImpl implements ProfilePictureService{

    @Autowired
    private ProfilePictureRepository profilePictureRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void addPicture(MultipartFile file, ProfilePictureDTO profilePictureDTO) throws FileUploadException {
        String filePath = "C:/spring/admin-dashboard/src/main/resources/profile-pecture/" + file.getOriginalFilename();

        try {
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            ProfilePicture profilePicture = modelMapper.map(profilePictureDTO, ProfilePicture.class);
            profilePicture.setImageName(file.getOriginalFilename());
            profilePicture.setImagePath(filePath);
            profilePictureRepository.save(profilePicture);
        } catch (Exception e) {
            throw new FileUploadException("File upload failed: " + e.getMessage());
        }


    }
}
