package project.SvetskoPrvenstvo.service;

import java.util.List;

import project.SvetskoPrvenstvo.model.Reprezentacija;

public interface ReprezentacijaService {

	List<Reprezentacija> getAll();

	Reprezentacija findOne(Long reprezentacija_AId);

}
