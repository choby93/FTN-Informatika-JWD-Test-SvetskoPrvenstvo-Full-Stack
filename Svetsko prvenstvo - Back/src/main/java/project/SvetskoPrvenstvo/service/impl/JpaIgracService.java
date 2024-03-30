package project.SvetskoPrvenstvo.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.SvetskoPrvenstvo.model.Igrac;
import project.SvetskoPrvenstvo.repository.IgracRepository;
import project.SvetskoPrvenstvo.service.IgracService;

@Service
public class JpaIgracService implements IgracService {

	@Autowired
	private IgracRepository igracRepository;

	@Override
	public List<Igrac> getAll() {
		List<Igrac> igraci = igracRepository.findAll();
		return igraci.stream().sorted(Comparator.comparingInt(Igrac::getBrGolova).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public Igrac findOne(Long id) {
		Optional<Igrac> igrac = igracRepository.findById(id);
		if (igrac.isPresent()) {
			return igrac.get();
		}
		return null;
	}

	@Override
	public Igrac strelacGola(Igrac igrac) {
		Igrac strelac = findOne(igrac.getId());
		if (strelac != null) {
			int staroStanje = strelac.getBrGolova();
			int novoStanje = staroStanje + 1;
			strelac.setBrGolova(novoStanje);
			igracRepository.save(strelac);
			return strelac;
		}
		return null;
	}

	@Override
	public List<Igrac> findByReprezentacijaId(Long reprezentacijaId) {

		return igracRepository.findByReprezentacijaId(reprezentacijaId);
	}

}
