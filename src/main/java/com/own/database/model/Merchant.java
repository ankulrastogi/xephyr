package com.own.database.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;



@Entity
@Table(appliesTo="Merchants")
public class Merchant {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="MerchantId",unique=true)
	private Integer id;
	
	@Column(name="merchantName")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
