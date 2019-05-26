package com.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId")
	private List<Acticle> acticles;

	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category(Integer id, String name, List<Acticle> acticles) {
		super();
		this.id = id;
		this.name = name;
		this.acticles = acticles;
	}

	public Category() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Acticle> getActicles() {
		return acticles;
	}

	public void setActicles(List<Acticle> acticles) {
		this.acticles = acticles;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", acticles=" + acticles.size() + "]";
	}

}
