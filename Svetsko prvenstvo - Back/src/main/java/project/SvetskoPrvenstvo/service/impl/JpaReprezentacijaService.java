package project.SvetskoPrvenstvo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.SvetskoPrvenstvo.model.Reprezentacija;
import project.SvetskoPrvenstvo.repository.ReprezentacijaRepository;
import project.SvetskoPrvenstvo.service.ReprezentacijaService;

@Service
public class JpaReprezentacijaService implements ReprezentacijaService {

	@Autowired
	ReprezentacijaRepository reprezentacijaRepository;

	@Override
	public List<Reprezentacija> getAll() {
		return reprezentacijaRepository.findAll();
	}

	@Override
	public Reprezentacija findOne(Long reprezentacija_AId) {
		Optional<Reprezentacija> reprezemOptional = reprezentacijaRepository.findById(reprezentacija_AId);
		if (reprezemOptional.isPresent()) {
			return reprezemOptional.get();
		}
		return null;
	}

}
