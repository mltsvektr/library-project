package ru.maltseva.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maltseva.libraryproject.model.UserList;

import java.util.Optional;

public interface UserListRepository extends JpaRepository<UserList, Long> {
    Optional<UserList> findByName(String name);
}
