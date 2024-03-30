package project.SvetskoPrvenstvo.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ReprezentacijaDto {

	private Long id;
	@NotBlank
	private String naziv;
	@Size(min = 3, max = 3)
	private String skraceniNaziv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

}
