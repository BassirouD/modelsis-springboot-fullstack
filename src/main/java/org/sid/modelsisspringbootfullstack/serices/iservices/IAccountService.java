package org.sid.modelsisspringbootfullstack.serices.iservices;

import org.sid.modelsisspringbootfullstack.entities.AppUser;

import java.util.List;

public interface IAccountService {
    public AppUser saveUser(String username, String password, String confirmedPassword);
    public AppUser loadUserByUsername(String username);

//    List<AppUser> all();
//    AppUser saveUser(String nom, String prenom, String telephone, String email, String adresse, String username, String password,String confirmedPassword,Boutique boutique);
//    AppRole saveRole(AppRole role);
//    Boutique saveBoutique(Boutique boutique);
//    void  addRoleAndBoutiqueToUser(String username, String rolename,Long idBoutique);
//    AppUser findUserByUsername(String username);
//    Collection<Boutique> getAllBoutiquesByUserId(Long userId);
//    AppUser saveEmployees(String nom, String prenom, String telephone, String email, String adresse, String username, String password,String confirmedPassword,Long boutique);
//    Collection<AppUser> findAllEmployeeById(Long idboutique, String roleName);
//    Collection<AppUser>  findAllEmployeeandUserById(Long idboutique);

}
