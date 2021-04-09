package com.mfm_app.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "username", length = 50)
	private String username;

	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@Column(name = "total_workouts")
	private int total_workouts = 0;

	@Column(name = "total_weight_lifted")
	private Double total_weight_lifted =0.0;

	@Column(name = "workouts_completed")
	@OneToMany(targetEntity = Workout.class)
	private List<Workout> workouts_completed = new ArrayList<>();

	@Column(name = "primary_bodypart_array")
	private ArrayList<Integer> primary_bodypart_array;
	
	@Column(name = "secondary_bodypart_array")
	private ArrayList<Integer> secondary_bodypart_array;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, int total_workouts, Double total_weight_lifted) {
		super();
		this.username = username;
		this.password = password;
		this.total_workouts = total_workouts;
		this.total_weight_lifted = total_weight_lifted;
		this.primary_bodypart_array = new ArrayList<Integer>();

		populate_arraylists();


	}

	private void populate_arraylists() {
		primary_bodypart_array.add(0, 0);
		primary_bodypart_array.add(1, 0);
		primary_bodypart_array.add(2, 0);
		secondary_bodypart_array.add(0, 0);
		secondary_bodypart_array.add(1, 0);
		secondary_bodypart_array.add(2, 0);
		secondary_bodypart_array.add(3, 0);
	}

	public List<Workout> getWorkouts_completed() {
		return workouts_completed;
	}

	public void setWorkouts_completed(List<Workout> workouts_completed) {
		this.workouts_completed = workouts_completed;
	}

	public ArrayList<Integer> getPrimary_bodypart_array() {
		return primary_bodypart_array;
	}

	public void setPrimary_bodypart_array(ArrayList<Integer> primary_bodypart_array) {
		this.primary_bodypart_array = primary_bodypart_array;
	}

	public ArrayList<Integer> getSecondary_bodypart_array() {
		return secondary_bodypart_array;
	}

	public void setSecondary_bodypart_array(ArrayList<Integer> secondary_bodypart_array) {
		this.secondary_bodypart_array = secondary_bodypart_array;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTotal_workouts() {
		return total_workouts;
	}

	public void setTotal_workouts(int total_workouts) {
		this.total_workouts = total_workouts;
	}
	
	public void increase_total_workouts() {
		this.total_workouts++;
	}
	public void decrease_total_workouts() {
		this.total_workouts--;
	}

	public Double getTotal_weight_lifted() {
		return total_weight_lifted;
	}

	public void setTotal_weight_lifted(Double total_weight_lifted) {
		this.total_weight_lifted = total_weight_lifted;
	}
	public void increase_total_weight_lifted(Double increase_amount) {
		this.total_weight_lifted = total_weight_lifted + increase_amount;
	}
	public void decrease_total_weight_lifted(Double decrease_amount) {
		this.total_weight_lifted = total_weight_lifted - decrease_amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((total_weight_lifted == null) ? 0 : total_weight_lifted.hashCode());
		result = prime * result + total_workouts;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (total_weight_lifted == null) {
			if (other.total_weight_lifted != null)
				return false;
		} else if (!total_weight_lifted.equals(other.total_weight_lifted))
			return false;
		if (total_workouts != other.total_workouts)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", total_workouts=" + total_workouts
				+ ", total_weight_lifted=" + total_weight_lifted + "]";
	}

}
