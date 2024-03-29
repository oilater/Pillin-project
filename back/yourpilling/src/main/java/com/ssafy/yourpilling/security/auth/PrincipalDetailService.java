package com.ssafy.yourpilling.security.auth;

import com.ssafy.yourpilling.security.auth.model.dao.jpa.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new PrincipalDetails(memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("회원을 찾을 수 없습니다.")));
    }
}

