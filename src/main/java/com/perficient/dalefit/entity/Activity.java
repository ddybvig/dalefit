package com.perficient.dalefit.entity;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Table(name="activity")
@Entity
@Data
public class Activity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;

	@Column(name="title", length=100)
	String title;
	
	@Column(name="description", length=500)
	String description;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sport_id")
	//@JsonIgnore
	Sport sport;
	
	LocalDate date;
	LocalTime startTime;
	Period duration;
	
}
