package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "autoinfo_ownerinfo")
public class RegistrationJunction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LINK_ID")
	private int id; // id created to map together the owner and auto via the junction table
	@ManyToOne
	@JoinColumn(name="autoId", referencedColumnName="AUTOINFO_ID")
	private AutoInfo auto;
	@ManyToOne
	@JoinColumn(name="ownerId", referencedColumnName="OWNERINFO_ID")
	private OwnerInfo owner;
		
	public RegistrationJunction() {
	
	}
	
	public RegistrationJunction(AutoInfo aId, OwnerInfo oId) {
		this.auto = aId;
		this.owner = oId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public AutoInfo getAuto() {
		return auto;
	}

	public void setAuto(AutoInfo auto) {
		this.auto = auto;
	}

	public OwnerInfo getOwner() {
		return owner;
	}

	public void setOwner(OwnerInfo owner) {
		this.owner = owner;
	}


	
	
}
