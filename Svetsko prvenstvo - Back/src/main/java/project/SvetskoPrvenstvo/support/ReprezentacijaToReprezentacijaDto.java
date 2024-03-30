package project.SvetskoPrvenstvo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.SvetskoPrvenstvo.model.Reprezentacija;
import project.SvetskoPrvenstvo.web.dto.ReprezentacijaDto;

@Component
public class ReprezentacijaToReprezentacijaDto implements Converter<Reprezentacija, ReprezentacijaDto> {

	@Override
	public ReprezentacijaDto convert(Reprezentacija rep) {

		ReprezentacijaDto dto = new ReprezentacijaDto();

		dto.setId(rep.getId());
		dto.setNaziv(rep.getNaziv());
		dto.setSkraceniNaziv(rep.getSkraceniNaziv());

		return dto;
	}

	public List<ReprezentacijaDto> convert(List<Reprezentacija> reprezentacija) {

		List<ReprezentacijaDto> dtoS = new ArrayList<>();

		for (Reprezentacija r : reprezentacija) {
			dtoS.add(convert(r));
		}

		return dtoS;
	}
}
