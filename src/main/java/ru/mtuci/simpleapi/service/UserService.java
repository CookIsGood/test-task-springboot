package ru.mtuci.simpleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtuci.simpleapi.entity.UserEntity;
import ru.mtuci.simpleapi.exceptions.UserAlreadyExistException;
import ru.mtuci.simpleapi.exceptions.UserNotFoundException;
import ru.mtuci.simpleapi.model.User;
import ru.mtuci.simpleapi.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistException("Пользователь уже сущетвует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException{
        UserEntity user = userRepo.findById(id).get();
        if(user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Iterable<UserEntity> getAll() {
        //Iterable<UserEntity> users = userRepo.findAll();
        return userRepo.findAll();
    }

    public Long deleteById(Long id) {
        userRepo.deleteById(id);
        return id;
    }

    public UserEntity update(String phone, Long id) {
        UserEntity user = userRepo.findById(id).get();
        user.setPhone(phone);
        return userRepo.save(user);
    }
}
