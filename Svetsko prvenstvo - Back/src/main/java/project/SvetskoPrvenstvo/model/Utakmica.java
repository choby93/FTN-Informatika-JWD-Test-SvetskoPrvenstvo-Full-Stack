package project.SvetskoPrvenstvo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Utakmica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Reprezentacija reprezentacija_A;
	@ManyToOne
	private Reprezentacija reprezentacija_B;
	@Column
	private int goloviTimA;
	@Column
	private int goloviTimB;

	public Utakmica() {
		super();
	}

	public Utakmica(Long id, Reprezentacija reprezentacija_A, Reprezentacija reprezentacija_B, int goloviTimA,
			int goloviTimB) {
		super();
		this.id = id;
		this.reprezentacija_A = reprezentacija_A;
		this.reprezentacija_B = reprezentacija_B;
		this.goloviTimA = goloviTimA;
		this.goloviTimB = goloviTimB;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Reprezentacija getReprezentacija_A() {
		return reprezentacija_A;
	}

	public void setReprezentacija_A(Reprezentacija reprezentacija_A) {
		this.reprezentacija_A = reprezentacija_A;
	}

	public Reprezentacija getReprezentacija_B() {
		return reprezentacija_B;
	}

	public void setReprezentacija_B(Reprezentacija reprezentacija_B) {
		this.reprezentacija_B = reprezentacija_B;
	}

	public int getGoloviTimA() {
		return goloviTimA;
	}

	public void setGoloviTimA(int goloviTimA) {
		this.goloviTimA = goloviTimA;
	}

	public int getGoloviTimB() {
		return goloviTimB;
	}

	public void setGoloviTimB(int goloviTimB) {
		this.goloviTimB = goloviTimB;
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
		Utakmica other = (Utakmica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
