package com.example.demo.security.service;

import java.util.List;
import java.util.Optional;

// import javax.annotation.PostConstruct;

import com.example.demo.security.entity.Utilisateur;
import com.example.demo.security.repository.UtilisateurRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UtilisateurService implements UserDetailsService {
    private static Logger log = LoggerFactory.getLogger(UtilisateurService.class);
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    
    
    @Autowired
    public UtilisateurService(final UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }
  
    // @PostConstruct
    // public void createUserDefault(){

    //     // log.info("Creation du user pars defaut");
    //     // Utilisateur utilisateur = new Utilisateur();
    //     // utilisateur.setLogin("Merlin");
    //     // utilisateur.setPassword(passwordEncoder.encode("1234"));
    //     // this.utilisateurRepository.save(utilisateur);
    // }
    
    @Override
    public UserDetails loadUserByUsername(final String login)
            throws UsernameNotFoundException {
        log.info("recuperation de {}", login);
    
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findByLogin(login);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            return new User(utilisateur.getLogin(), utilisateur.getPassword(), List.of());
        } else {
            throw new UsernameNotFoundException("L'utilisateur" + login + " n'existe pas");
        }

    }
}
