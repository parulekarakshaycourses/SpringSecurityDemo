package com.example.SpringSecurityDemo.security;

import com.example.SpringSecurityDemo.entity.User;
import com.example.SpringSecurityDemo.repository.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailService implements UserDetailsService
{
    private final UserRepo userRepo;

    public MyUserDetailService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        User user = userRepo.getByUsername(email);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid User");
        }
        else
        {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            if(user.getIdDesignation() == 0)
            {
                grantedAuthorities.add(
                        new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
            else if(user.getIdDesignation() == 1)
            {
                grantedAuthorities.add(
                        new SimpleGrantedAuthority("ROLE_EMP"));
            }
            // similarly you can check for other designations like manager, analyst etc
            else
            {
                throw new UsernameNotFoundException("Invalid User");
            }

            return new org
                    .springframework
                    .security
                    .core
                    .userdetails
                    .User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
    }
}