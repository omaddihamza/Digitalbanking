package org.sid.repository;

import org.sid.entities.ProfilePicture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, Long> {
}
