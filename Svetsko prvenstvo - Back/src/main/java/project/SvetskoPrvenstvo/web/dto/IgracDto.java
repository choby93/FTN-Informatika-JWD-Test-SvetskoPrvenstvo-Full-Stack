package project.SvetskoPrvenstvo.web.dto;

public class IgracDto {

	private Long id;

	private String ime;

	private String prezime;

	private int brGolova;

	private Long reprezentacijaId;

	private String reprezentacijaIme;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getBrGolova() {
		return brGolova;
	}

	public void setBrGolova(int brGolova) {
		this.brGolova = brGolova;
	}

	public Long getReprezentacijaId() {
		return reprezentacijaId;
	}

	public void setReprezentacijaId(Long reprezentacijaId) {
		this.reprezentacijaId = reprezentacijaId;
	}

	public String getReprezentacijaIme() {
		return reprezentacijaIme;
	}

	public void setReprezentacijaIme(String reprezentacijaIme) {
		this.reprezentacijaIme = reprezentacijaIme;
	}

}
