package project.SvetskoPrvenstvo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.SvetskoPrvenstvo.model.Utakmica;
import project.SvetskoPrvenstvo.web.dto.UtakmicaDto;

@Component
public class UtakmicaToUtakmicaDto implements Converter<Utakmica, UtakmicaDto> {

	@Override
	public UtakmicaDto convert(Utakmica utakmica) {

		UtakmicaDto dto = new UtakmicaDto();

		dto.setId(utakmica.getId());
		dto.setReprezentacija_AId(utakmica.getReprezentacija_A().getId());
		dto.setReprezentacija_AIme(utakmica.getReprezentacija_A().getNaziv());
		dto.setReprezentacija_BId(utakmica.getReprezentacija_B().getId());
		dto.setReprezentacija_BIme(utakmica.getReprezentacija_B().getNaziv());
		dto.setGoloviTimA(utakmica.getGoloviTimA());
		dto.setGoloviTimB(utakmica.getGoloviTimB());
		return dto;

	}

	public List<UtakmicaDto> convert(List<Utakmica> utakmica) {

		List<UtakmicaDto> dtoS = new ArrayList<>();

		for (Utakmica u : utakmica) {
			dtoS.add(convert(u));
		}

		return dtoS;
	}

}
