package com.capgemini.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String mailId;
	private Long contactNumber;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	private List<Project> projects;
}