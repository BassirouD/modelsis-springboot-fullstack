package org.sid.modelsisspringbootfullstack.serices;

import org.sid.modelsisspringbootfullstack.dao.AppUserRepo;
import org.sid.modelsisspringbootfullstack.entities.AppUser;
import org.sid.modelsisspringbootfullstack.serices.iservices.IAccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService implements IAccountService {

    private AppUserRepo appUserRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountService(AppUserRepo appUserRepo, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.appUserRepo = appUserRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword) {
        AppUser appUser = appUserRepo.findByUsername(username);
        if (appUser != null) throw new RuntimeException("USer already exist");
        if (!password.equals(confirmedPassword)) throw new RuntimeException("Pleasee confirm your password");
        AppUser appUser1 = new AppUser();
        appUser1.setUsername(username);
        appUser1.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepo.save(appUser1);
        return appUser1;
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }
}
