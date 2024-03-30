package project.SvetskoPrvenstvo.web.dto;

public class UtakmicaDto {

	private Long id;

	private Long reprezentacija_AId;

	private String reprezentacija_AIme;

	private Long reprezentacija_BId;

	private String reprezentacija_BIme;

	private Integer goloviTimA;

	private Integer goloviTimB;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReprezentacija_AId() {
		return reprezentacija_AId;
	}

	public void setReprezentacija_AId(Long reprezentacija_AId) {
		this.reprezentacija_AId = reprezentacija_AId;
	}

	public String getReprezentacija_AIme() {
		return reprezentacija_AIme;
	}

	public void setReprezentacija_AIme(String reprezentacija_AIme) {
		this.reprezentacija_AIme = reprezentacija_AIme;
	}

	public Long getReprezentacija_BId() {
		return reprezentacija_BId;
	}

	public void setReprezentacija_BId(Long reprezentacija_BId) {
		this.reprezentacija_BId = reprezentacija_BId;
	}

	public String getReprezentacija_BIme() {
		return reprezentacija_BIme;
	}

	public void setReprezentacija_BIme(String reprezentacija_BIme) {
		this.reprezentacija_BIme = reprezentacija_BIme;
	}

	public Integer getGoloviTimA() {
		return goloviTimA;
	}

	public void setGoloviTimA(Integer goloviTimA) {
		this.goloviTimA = goloviTimA;
	}

	public Integer getGoloviTimB() {
		return goloviTimB;
	}

	public void setGoloviTimB(Integer goloviTimB) {
		this.goloviTimB = goloviTimB;
	}

	
}
