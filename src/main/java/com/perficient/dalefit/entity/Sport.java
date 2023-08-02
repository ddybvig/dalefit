package com.perficient.dalefit.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="sport")
@Data
public class Sport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@Column(name="name")
	String name;
	@OneToMany(mappedBy="sport", cascade=CascadeType.ALL)
	@JsonIgnore
	List<Activity> activities;
	
}
