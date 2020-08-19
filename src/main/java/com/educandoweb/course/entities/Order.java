package com.educandoweb.course.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long Id;
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	public Order() {
	}

	public Order(Long id, Instant moment, User client) {
		super();
		Id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [Id=" + Id + ", client=" + client + "]";
	}
	
	
}


/*@ManyToOne --> Annotation que serve para instruir o JPA que transforma em um chave estrangeira;
 * @JoinColumn(name = "client_id") --> Nome da chave estrangeira;
 * @Table(name = "tb_order") --> Para que nao haja conflito com as palavras reservadas pelo SQL;
 */

