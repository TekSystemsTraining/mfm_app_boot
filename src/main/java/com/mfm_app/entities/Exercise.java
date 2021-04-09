package com.mfm_app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Exercises")
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="name", unique=true)
	private String name;
	
	@Column(name="primary_bodypart")
	private String primary_bodypart;
	
	@Column(name="secondary_bodypart")
	private String secondary_bodypart;

	public Exercise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exercise(int id, String name, String primary_bodypart, String secondary_bodypart) {
		super();
		this.id = id;
		this.name = name;
		this.primary_bodypart = primary_bodypart;
		this.secondary_bodypart = secondary_bodypart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimary_bodypart() {
		return primary_bodypart;
	}

	public void setPrimary_bodypart(String primary_bodypart) {
		this.primary_bodypart = primary_bodypart;
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
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((primary_bodypart == null) ? 0 : primary_bodypart.hashCode());
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
		Exercise other = (Exercise) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (primary_bodypart == null) {
			if (other.primary_bodypart != null)
				return false;
		} else if (!primary_bodypart.equals(other.primary_bodypart))
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
		return "Exercise [id=" + id + ", name=" + name + ", primary_bodypart=" + primary_bodypart
				+ ", secondary_bodypart=" + secondary_bodypart + "]";
	}
	
	
}
