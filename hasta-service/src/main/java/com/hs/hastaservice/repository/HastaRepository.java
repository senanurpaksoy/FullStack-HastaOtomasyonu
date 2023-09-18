package com.hs.hastaservice.repository;

import com.hs.hastaservice.entity.Hasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HastaRepository extends JpaRepository<Hasta,Long> {
}
