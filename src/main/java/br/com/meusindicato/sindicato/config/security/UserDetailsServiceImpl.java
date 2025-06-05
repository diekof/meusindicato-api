package br.com.meusindicato.sindicato.config.security;

import br.com.meusindicato.sindicato.model.SecUser;
import br.com.meusindicato.sindicato.repository.SecUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SecUserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username){
//        SecUser user = userRepository
//                .findByUsername(username)
//                .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado com username"));
//        return (UserDetails) user;
//    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecUser usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return usuario;
    }
}