package org.sid.services;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.modelmapper.ModelMapper;
import org.sid.dto.ProfileDTO;
import org.sid.entities.Profile;
import org.sid.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileServise{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public void saveProfile(ProfileDTO profileDTO)  {
            Profile profile = modelMapper.map(profileDTO, Profile.class);
            profileRepository.save(profile);
    }

    @Override
    public List<Profile> all() {
        return profileRepository.findAll();
    }
}
