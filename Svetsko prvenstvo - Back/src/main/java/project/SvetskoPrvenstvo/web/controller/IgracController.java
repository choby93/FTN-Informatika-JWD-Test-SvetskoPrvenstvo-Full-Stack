package project.SvetskoPrvenstvo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.SvetskoPrvenstvo.model.Igrac;
import project.SvetskoPrvenstvo.service.IgracService;
import project.SvetskoPrvenstvo.support.IgracToIgracDto;
import project.SvetskoPrvenstvo.web.dto.IgracDto;

@RestController
@RequestMapping(value = "api/igraci")
public class IgracController {

	@Autowired
	private IgracToIgracDto toIgracDto;

	@Autowired
	private IgracService igracService;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<IgracDto>> getAll() {
		List<Igrac> igrac = igracService.getAll();
		if (igrac != null) {
			return new ResponseEntity<>(toIgracDto.convert(igrac), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping(value = "/reprezentacija")
	public ResponseEntity<List<IgracDto>> getAllByreprezentacija(@RequestParam Long reprezentacijaId) {
		List<Igrac> igrac = igracService.findByReprezentacijaId(reprezentacijaId);
		return new ResponseEntity<>(toIgracDto.convert(igrac), HttpStatus.OK);
	}

//	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PutMapping(value = "/{id}/strelac")
	public ResponseEntity<IgracDto> strelac(@PathVariable Long id) {
		Igrac igrac = igracService.findOne(id);
		if (igrac == null || igrac.getReprezentacija() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		igracService.strelacGola(igrac);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
