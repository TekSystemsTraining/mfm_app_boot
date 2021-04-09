package com.mfm_app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PrimaryBodypartList {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="primary_bodypart")
	private String primary_bodypart;

	public PrimaryBodypartList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrimaryBodypartList(Long id, String primary_bodypart) {
		super();
		this.id = id;
		this.primary_bodypart = primary_bodypart;
	}

	public String getPrimary_bodypart() {
		return primary_bodypart;
	}

	public void setPrimary_bodypart(String primary_bodypart) {
		this.primary_bodypart = primary_bodypart;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((primary_bodypart == null) ? 0 : primary_bodypart.hashCode());
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
		PrimaryBodypartList other = (PrimaryBodypartList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (primary_bodypart == null) {
			if (other.primary_bodypart != null)
				return false;
		} else if (!primary_bodypart.equals(other.primary_bodypart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrimaryBodypartList [id=" + id + ", primary_bodypart=" + primary_bodypart + "]";
	}

	
	
}
