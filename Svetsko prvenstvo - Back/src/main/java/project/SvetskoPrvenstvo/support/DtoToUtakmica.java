package project.SvetskoPrvenstvo.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.SvetskoPrvenstvo.model.Utakmica;
import project.SvetskoPrvenstvo.service.ReprezentacijaService;
import project.SvetskoPrvenstvo.service.UtakmicaService;
import project.SvetskoPrvenstvo.web.dto.UtakmicaDto;

@Component
public class DtoToUtakmica implements Converter<UtakmicaDto, Utakmica> {

	@Autowired
	private UtakmicaService utakmicaService;
	@Autowired
	private ReprezentacijaService reprezentacijaService;

	@Override
	public Utakmica convert(UtakmicaDto dto) {

		Utakmica utakmica = null;

		if (dto.getId() == null) {
			utakmica = new Utakmica();
		} else {
			utakmica = utakmicaService.findOne(dto.getId());
		}

		if (utakmica != null) {
			utakmica.setReprezentacija_A(reprezentacijaService.findOne(dto.getReprezentacija_AId()));
			utakmica.setReprezentacija_B(reprezentacijaService.findOne(dto.getReprezentacija_BId()));
			if (dto.getGoloviTimA() == null) {
				utakmica.setGoloviTimA(0);
			} else {
				utakmica.setGoloviTimA(dto.getGoloviTimA());
			}
			if (dto.getGoloviTimB() == null) {
				utakmica.setGoloviTimB(0);
			} else {
				utakmica.setGoloviTimB(dto.getGoloviTimB());
			}

		}

		return utakmica;
	}

}
