package project.SvetskoPrvenstvo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.SvetskoPrvenstvo.model.Igrac;
import project.SvetskoPrvenstvo.web.dto.IgracDto;

@Component
public class IgracToIgracDto implements Converter<Igrac, IgracDto> {

	@Override
	public IgracDto convert(Igrac igrac) {
		IgracDto dto = new IgracDto();

		dto.setId(igrac.getId());
		dto.setIme(igrac.getIme());
		dto.setPrezime(igrac.getPrezime());
		dto.setBrGolova(igrac.getBrGolova());
		dto.setReprezentacijaId(igrac.getReprezentacija().getId());
		dto.setReprezentacijaIme(igrac.getReprezentacija().getNaziv());

		return dto;
	}

	public List<IgracDto> convert(List<Igrac> igrac) {

		List<IgracDto> dtoS = new ArrayList<>();

		for (Igrac i : igrac) {
			dtoS.add(convert(i));
		}

		return dtoS;
	}

}
