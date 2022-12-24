package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})


@Data
@Builder(setterPrefix = "set")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Adress {

	@ToString.Include
	@EqualsAndHashCode.Include
	@Id
	@SequenceGenerator(name = "adres_sequence", sequenceName = "sq_adres",allocationSize = 1_000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adres_sequence")
	private Long id;
	@Column
	private Integer no;
	@Column
	private String house;
	
	
	public Adress(Long id) {
		this.id = id;
	}

}
