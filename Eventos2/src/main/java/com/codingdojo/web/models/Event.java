package com.codingdojo.web.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.codingdojo.web.authentication.models.User;

@Entity
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name must be valid")
	private String Name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date dateEvent;
	
	private String stateEvent;
	
	private String ubication;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    /*
    //EVENT a STATE
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="state_id")
    private State stateEvent;
    */
    //USER a EVENT 1:N
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User userEvent;
    
    
    //MANY
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "userHasEvent",
    joinColumns = @JoinColumn(name = "event_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> asistente;
    
    public Event() {
    }

    // otros getters y setters removidos para resumir.
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getUbication() {
		return ubication;
	}

	public void setUbication(String ubication) {
		this.ubication = ubication;
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

	public User getUserEvent() {
		return userEvent;
	}

	public void setUserEvent(User userEvent) {
		this.userEvent = userEvent;
	}

	public String getStateEvent() {
		return stateEvent;
	}

	public void setStateEvent(String stateEvent) {
		this.stateEvent = stateEvent;
	}

	


}
