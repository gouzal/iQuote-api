package com.gouzal.iquote.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("MyUserDetailsService")
public class MyUserDetailsService /*implements UserDetailsService*/ {
    private UserService userService;

    @Autowired
    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    /*@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new UserToUserDetails().convert(this.userService.findFirstByLogin(userName));
    }*/
}
