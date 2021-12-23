package com.Bigdata.safetycity.config.auth;


import com.Bigdata.safetycity.model.User;
import com.Bigdata.safetycity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // 스프링이 로그인 요청을 가로챌 때 username, password 변수 2개를 가로채는데
    // password 부분 처리는 알아서함.
    // username이 db에 있는지만 확인해주면됨

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(s)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.");
                });
        return new PrincipalDetail(principal);
    }

}