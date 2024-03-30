package project.SvetskoPrvenstvo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.SvetskoPrvenstvo.model.Reprezentacija;

@Repository
public interface ReprezentacijaRepository extends JpaRepository<Reprezentacija, Long> {

}
