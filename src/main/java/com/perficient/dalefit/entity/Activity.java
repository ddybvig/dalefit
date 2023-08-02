package com.perficient.dalefit.entity;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	
	@ManyToOne
	@JoinColumn(name="sport")
	//@JsonIgnore
	Sport sport;
	
	@Temporal(TemporalType.DATE)
	LocalDate date;
	
	@Temporal(TemporalType.TIME)
	LocalTime startTime;
	
	//TODO: implement dateTime instead of date and time to make sorting on the same date easier
	//LocalDateTime dateTime;
	
	Duration duration;
	
	double distanceInMiles;
	
}
