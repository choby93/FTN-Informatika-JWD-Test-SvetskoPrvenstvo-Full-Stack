package project.SvetskoPrvenstvo.service;

import org.springframework.data.domain.Page;

import project.SvetskoPrvenstvo.model.Utakmica;

public interface UtakmicaService {

	Page<Utakmica> getAll(int pageNo, Long reprezentacijaA, Long reprezentacijaB);

	Utakmica findOne(Long id);

	Utakmica create(Utakmica utakmica);

	Utakmica update(Utakmica utakmica);

	Utakmica delete(Long id);

	Utakmica addGoalTeamA(Utakmica utakmica);

	Utakmica save(Utakmica utakmica);

	Utakmica addGoalTeamB(Utakmica utakmica);

}
