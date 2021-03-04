package com.codingdojo.web.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.codingdojo.web.authentication.models.User;

@Entity
@Table(name = "states")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String stateName;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    /*
    //USER a STATE
    @OneToOne(mappedBy="stateUser", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private User userState;
    
    //Event a STATE
    @OneToOne(mappedBy="stateEvent", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Event eventState;
    */
    
    public State() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
    
}
