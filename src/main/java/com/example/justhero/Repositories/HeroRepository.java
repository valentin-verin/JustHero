package com.example.justhero.Repositories;

import com.example.justhero.Models.Hero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HeroRepository extends JpaRepository<Hero, Long > {
    @Query("select h from Hero h where h.nom like :x")
    public Page<Hero> rechercher(@Param("x")String nom, Pageable pageable);
}
