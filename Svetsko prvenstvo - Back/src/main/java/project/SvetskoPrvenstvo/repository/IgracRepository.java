package project.SvetskoPrvenstvo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.SvetskoPrvenstvo.model.Igrac;

@Repository
public interface IgracRepository extends JpaRepository<Igrac, Long> {

	List<Igrac> findByReprezentacijaId(Long reprezentacijaId);

}
