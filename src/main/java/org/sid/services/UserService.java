package org.sid.services;

import org.sid.entities.UserEntity;
import java.util.List;

public interface UserService {
    List<UserEntity> userList();
}
