package ryzhenin.dz11.repository;

import org.springframework.stereotype.Repository;
import ryzhenin.dz11.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<UserEntity> users = new ArrayList<>();
    private long nextId = 1;

    public UserEntity save(UserEntity user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    public Optional<UserEntity> findByLogin(String login) {
        return users.stream().filter(u -> u.getLogin().equals(login)).findFirst();
    }
}