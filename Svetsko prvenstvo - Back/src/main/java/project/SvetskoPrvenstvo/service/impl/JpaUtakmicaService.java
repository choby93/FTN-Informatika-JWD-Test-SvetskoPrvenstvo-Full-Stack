package project.SvetskoPrvenstvo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import project.SvetskoPrvenstvo.model.Utakmica;
import project.SvetskoPrvenstvo.repository.UtakmicaRepository;
import project.SvetskoPrvenstvo.service.UtakmicaService;

@Service
public class JpaUtakmicaService implements UtakmicaService {

	@Autowired
	private UtakmicaRepository utakmicaRepository;

	@Override
	public Page<Utakmica> getAll(int pageNo, Long reprezentacijaA, Long reprezentacijaB) {
		return utakmicaRepository.search(reprezentacijaA, reprezentacijaB, PageRequest.of(pageNo, 3));
	}

	@Override
	public Utakmica findOne(Long id) {
		Optional<Utakmica> optionalUtakmica = utakmicaRepository.findById(id);
		if (optionalUtakmica.isPresent()) {
			return optionalUtakmica.get();
		}
		return null;
	}

	@Override
	public Utakmica create(Utakmica utakmica) {
		return utakmicaRepository.save(utakmica);
	}

	@Override
	public Utakmica update(Utakmica utakmica) {
		return utakmicaRepository.save(utakmica);
	}

	@Override
	public Utakmica delete(Long id) {
		Utakmica utakmica = findOne(id);
		if (utakmica != null) {
			utakmicaRepository.delete(utakmica);
			return utakmica;
		}
		return null;
	}

	@Override
	public Utakmica save(Utakmica utakmica) {
		return utakmicaRepository.save(utakmica);
	}

	@Override
	public Utakmica addGoalTeamA(Utakmica utakmica) {

		Utakmica timA = findOne(utakmica.getId());
		if (timA != null) {
			int staroStanje = timA.getGoloviTimA();
			int novoStanje = staroStanje + 1;
			timA.setGoloviTimA(novoStanje);
			utakmicaRepository.save(timA);
			return timA;
		}

		return null;
	}

	@Override
	public Utakmica addGoalTeamB(Utakmica utakmica) {

		Utakmica timB = findOne(utakmica.getId());
		if (timB != null) {
			int staroStanje = timB.getGoloviTimB();
			int novoStanje = staroStanje + 1;
			timB.setGoloviTimB(novoStanje);
			utakmicaRepository.save(timB);
			return timB;
		}

		return null;
	}

}
