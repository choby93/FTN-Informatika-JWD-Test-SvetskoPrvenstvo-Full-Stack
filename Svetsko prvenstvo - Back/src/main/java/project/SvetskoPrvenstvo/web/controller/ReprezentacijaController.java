package project.SvetskoPrvenstvo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.SvetskoPrvenstvo.model.Reprezentacija;
import project.SvetskoPrvenstvo.service.ReprezentacijaService;
import project.SvetskoPrvenstvo.support.ReprezentacijaToReprezentacijaDto;
import project.SvetskoPrvenstvo.web.dto.ReprezentacijaDto;

@RestController
@RequestMapping(value = "api/reprezentacije")
public class ReprezentacijaController {

	@Autowired
	private ReprezentacijaToReprezentacijaDto reprezentacijaToDto;

	@Autowired
	private ReprezentacijaService reprezentacijaService;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<ReprezentacijaDto>> getAll() {
		List<Reprezentacija> reprezentacija = reprezentacijaService.getAll();
		return new ResponseEntity<>(reprezentacijaToDto.convert(reprezentacija), HttpStatus.OK);
	}
}
