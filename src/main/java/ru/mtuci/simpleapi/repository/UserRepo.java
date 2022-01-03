package ru.mtuci.simpleapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mtuci.simpleapi.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
