package com.Bigdata.safetycity.config.auth;


import com.Bigdata.safetycity.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면
// UserDetails타입의 오브젝트를 고유한 세션 저장소에 저장해준다.
@Getter
public class PrincipalDetail implements UserDetails {
    private User user; // 컴포지션

    public PrincipalDetail(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //비밀번호 만료되지 않았는지 리턴한다.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 활성화인지 리턴한다.
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        /*
            collectors.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_" + user.getRole();
                // 규칙이라 반드시 ROLE_가 필요하다.
            }
        });
        */
        return collectors;
    }
}
