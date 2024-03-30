package project.SvetskoPrvenstvo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Igrac {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String ime;
	@Column(nullable = false)
	private String prezime;
	@Column
	private int brGolova;
	@ManyToOne
	private Reprezentacija reprezentacija;

	public Igrac() {
	}

	public Igrac(Long id, String ime, String prezime, int brGolova, Reprezentacija reprezentacija) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.brGolova = brGolova;
		this.reprezentacija = reprezentacija;
	}

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

	public Reprezentacija getReprezentacija() {
		return reprezentacija;
	}

	public void setReprezentacija(Reprezentacija reprezentacija) {
		this.reprezentacija = reprezentacija;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Igrac other = (Igrac) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
