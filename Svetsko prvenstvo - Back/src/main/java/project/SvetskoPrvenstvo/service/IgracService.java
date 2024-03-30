package project.SvetskoPrvenstvo.service;

import java.util.List;

import project.SvetskoPrvenstvo.model.Igrac;

public interface IgracService {

	List<Igrac> getAll();

	Igrac findOne(Long id);

	Igrac strelacGola(Igrac igrac);

	List<Igrac> findByReprezentacijaId(Long reprezentacijaId);

}
