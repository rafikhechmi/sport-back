package com.project.sport.security;

import com.project.sport.models.Role;
import com.project.sport.models.User;
import com.project.sport.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Incorrect username or password");
        }
        return new UserPrincipal(username, user.getPassword(), extractGrantedAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> extractGrantedAuthorities(User user) {
        return Optional.ofNullable(user).map(User::getRoles).map(this::convertToGrantedAuthorities).orElse(null);
    }

    private Set<SimpleGrantedAuthority> convertToGrantedAuthorities(List<Role> roles) {
        return roles.stream().map(Role::getName).map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toSet());
    }
}