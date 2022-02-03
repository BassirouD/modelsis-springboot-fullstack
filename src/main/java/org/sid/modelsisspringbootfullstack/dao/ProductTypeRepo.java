package org.sid.modelsisspringbootfullstack.dao;

import org.sid.modelsisspringbootfullstack.entities.AppUser;
import org.sid.modelsisspringbootfullstack.entities.ProdcutType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepo extends JpaRepository<ProdcutType, Long> {
    public ProdcutType findByName(String username);
}
