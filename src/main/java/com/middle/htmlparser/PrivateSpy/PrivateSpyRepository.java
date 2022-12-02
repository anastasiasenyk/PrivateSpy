package com.middle.htmlparser.PrivateSpy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivateSpyRepository extends JpaRepository<PrivateSpy, Integer> {

    @Query("Select f FROM PrivateSpy f WHERE f.id=?1")
    Optional<PrivateSpy> findSpyById(Integer id);

    @Query("Select f FROM PrivateSpy f WHERE f.domain=?1")
    Optional<PrivateSpy> findSpyByDomain(String domain);
}
