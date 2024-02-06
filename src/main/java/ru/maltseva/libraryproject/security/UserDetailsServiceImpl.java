package ru.maltseva.libraryproject.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.maltseva.libraryproject.model.UserList;
import ru.maltseva.libraryproject.repository.UserListRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserListRepository userListRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserList userList = userListRepository.findByName(username).orElseThrow();
        return UserDetailsImpl.build(userList);
    }
}
