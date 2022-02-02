package org.sid.modelsisspringbootfullstack.dao;

import org.sid.modelsisspringbootfullstack.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    public AppUser findByUsername(String username);
}
