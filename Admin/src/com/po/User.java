package com.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	private String uname;
	private boolean sex;
	@AttributeOverrides({@AttributeOverride(name="firstName",column=@Column(name="first_name")),
			@AttributeOverride(name="lastName",column=@Column(name="last_name"))})
	private FullName fullName;
	@ElementCollection
	@JoinTable(name="tels",joinColumns=@JoinColumn(name="u_id"))
	@Column(name="tel_code1")
	private Set<String> tels=new HashSet<String>();
	
	
	public FullName getFullName() {
		return fullName;
	}
	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}
	public Set<String> getTels() {
		return tels;
	}
	public void setTels(Set<String> tels) {
		this.tels = tels;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	
}
