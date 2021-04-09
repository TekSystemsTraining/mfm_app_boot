package com.mfm_app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SecondaryBodypartList {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="secondary_bodypart")
	private String secondary_bodypart;

	public SecondaryBodypartList(Long id, String secondary_bodypart) {
		super();
		this.id = id;
		this.secondary_bodypart = secondary_bodypart;
	}

	public SecondaryBodypartList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public String getSecondary_bodypart() {
		return secondary_bodypart;
	}

	public void setSecondary_bodypart(String secondary_bodypart) {
		this.secondary_bodypart = secondary_bodypart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((secondary_bodypart == null) ? 0 : secondary_bodypart.hashCode());
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
		SecondaryBodypartList other = (SecondaryBodypartList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (secondary_bodypart == null) {
			if (other.secondary_bodypart != null)
				return false;
		} else if (!secondary_bodypart.equals(other.secondary_bodypart))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SecondaryBodypartList [id=" + id + ", secondary_bodypart=" + secondary_bodypart + "]";
	}
	
	
}
