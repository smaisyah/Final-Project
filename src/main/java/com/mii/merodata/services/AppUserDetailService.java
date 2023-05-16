package com.mii.merodata.services;

import com.mii.merodata.models.AppUserDetail;
import com.mii.merodata.models.User;
import com.mii.merodata.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService {

  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    User user = userRepository
      .findByUsernameOrEmployee_Email(username, username)
      .orElseThrow(() ->
        new UsernameNotFoundException("Username or Email incorrect!!!")
      );
    return new AppUserDetail(user);
  }
}
