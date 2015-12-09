package com.yash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "Roles")
@Table(name = "roles")  
public class Roles 
{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="ROLE_NAME")
	private String roleName;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", roleName=" + roleName + "]";
	}
	
}
