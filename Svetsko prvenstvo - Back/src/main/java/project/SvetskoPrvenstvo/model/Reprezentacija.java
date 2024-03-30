package project.SvetskoPrvenstvo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reprezentacija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String naziv;
	@Column(nullable = false, unique = true)
	private String skraceniNaziv;
	@OneToMany(mappedBy = "reprezentacija")
	private List<Igrac> igraci = new ArrayList<>();
	@OneToMany(mappedBy = "reprezentacija_A")
	private List<Utakmica> timA = new ArrayList<>();
	@OneToMany(mappedBy = "reprezentacija_B")
	private List<Utakmica> timB = new ArrayList<>();

	public Reprezentacija() {
		super();
	}

	public Reprezentacija(Long id, String naziv, String skraceniNaziv, List<Igrac> igraci, List<Utakmica> timA,
			List<Utakmica> timB) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.skraceniNaziv = skraceniNaziv;
		this.igraci = igraci;
		this.timA = timA;
		this.timB = timB;
	}

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

	public List<Igrac> getIgraci() {
		return igraci;
	}

	public void setIgraci(List<Igrac> igraci) {
		this.igraci = igraci;
	}

	public List<Utakmica> getTimA() {
		return timA;
	}

	public void setTimA(List<Utakmica> timA) {
		this.timA = timA;
	}

	public List<Utakmica> getTimB() {
		return timB;
	}

	public void setTimB(List<Utakmica> timB) {
		this.timB = timB;
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
		Reprezentacija other = (Reprezentacija) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
