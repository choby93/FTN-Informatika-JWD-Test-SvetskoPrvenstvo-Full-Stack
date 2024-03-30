package project.SvetskoPrvenstvo.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.SvetskoPrvenstvo.model.Utakmica;
import project.SvetskoPrvenstvo.service.UtakmicaService;
import project.SvetskoPrvenstvo.support.DtoToUtakmica;
import project.SvetskoPrvenstvo.support.UtakmicaToUtakmicaDto;
import project.SvetskoPrvenstvo.web.dto.UtakmicaDto;

@RestController
@RequestMapping(value = "api/utakmice", produces = MediaType.APPLICATION_JSON_VALUE)
public class UtakmicaController {

	@Autowired
	private UtakmicaService utakmicaService;
	@Autowired
	private UtakmicaToUtakmicaDto toDto;
	@Autowired
	private DtoToUtakmica toUtakmica;

	@PreAuthorize("permitAll()")
	@GetMapping
	public ResponseEntity<List<UtakmicaDto>> get(@RequestParam(required = false, defaultValue = "0") int pageNo,
			@RequestParam(required = false) Long reprezentacijaA,
			@RequestParam(required = false) Long reprezentacijaB) {

		Page<Utakmica> pageUtakmica = utakmicaService.getAll(pageNo, reprezentacijaA, reprezentacijaB);

		HttpHeaders headers = new HttpHeaders();
		headers.add("total-pages", Integer.toString(pageUtakmica.getTotalPages()));
		return new ResponseEntity<>(toDto.convert(pageUtakmica.getContent()), headers, HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping(value = "/{id}")
	public ResponseEntity<UtakmicaDto> getOne(@PathVariable Long id) {

		Utakmica utakmica = utakmicaService.findOne(id);
		if (utakmica != null) {
			return new ResponseEntity<>(toDto.convert(utakmica), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDto> create(@Valid @RequestBody UtakmicaDto dto) {

		Utakmica utakmica = toUtakmica.convert(dto);
		if (utakmica.getReprezentacija_A() == utakmica.getReprezentacija_B()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Utakmica savedUtakmica = utakmicaService.create(utakmica);
		return new ResponseEntity<>(toDto.convert(savedUtakmica), HttpStatus.OK);

	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDto> update(@PathVariable Long id, @Valid @RequestBody UtakmicaDto dto) {

		if (!id.equals(dto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Utakmica utakmica = toUtakmica.convert(dto);
		Utakmica savedUtakmica = utakmicaService.update(utakmica);

		return new ResponseEntity<>(toDto.convert(savedUtakmica), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UtakmicaDto> delete(@PathVariable Long id) {

		Utakmica deletedUtakmica = utakmicaService.delete(id);

		if (deletedUtakmica == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PutMapping(value = "/{id}/repAGol")
	public ResponseEntity<UtakmicaDto> addGoalA(@PathVariable Long id) {

		Utakmica utakmica = utakmicaService.findOne(id);
		if (utakmica == null) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		utakmicaService.addGoalTeamA(utakmica);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PutMapping(value = "/{id}/repBGol")
	public ResponseEntity<UtakmicaDto> addGoalB(@PathVariable Long id) {

		Utakmica utakmica = utakmicaService.findOne(id);
		if (utakmica == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		utakmicaService.addGoalTeamB(utakmica);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
