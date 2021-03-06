package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name = "tb_product")
public class Product implements Serializable {  
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name = "tb_product_categoy", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "categoy_id"))
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	
	public Product() {
		
	}

	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	@JsonIgnore
	public Set<Order> getOrders(){
		Set<Order> set = new HashSet<>();
		for (OrderItem x : items) {
			set.add(x.getOrder());;
		}
		return set;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}


/* Set<category> --> O set representa um conjunto, isso garante que nao terá um produto com mais de uma ocorrencia de uma mesma categoria. O mesmo produto nao pode ter uma mesma categoria mais de uma vez;
 * 
 * Para garantir que a coleção nao comece nulo temos que instanciar('new HashSet<>();'), ela deve começar vazia, porem instanciada;
 * 
 * Usamos o HashSet ao inves do Set para instanciar, é pq o Set é uma interface, ele não pode ser instanciado, entao devemos usar um classe(HashSet) que represente essa interface;
 * 
 *No construtor não é necessário colocar a coleção(category) pq ela já foi instanciada anteriomente; 
 *
 *@JoinTable --> Existe  objetos associados entre si no modelo de dados do paradigma orietado a objetos. No Banco de Dados relacional a associação(@ManyToMany) dos produtos com a categoria(exemplo),  precisa existir uma tabela de associação e para isso é necessário mapear as classes para a tabela de associação no BD relacional.
 *
 *joincolumns e o inverseJoinColumns --> São necessários pq é associação entre duas tabelas
 *
 *Set<OrderItem> --> Informa ao JPA que nao vai adimitir repetições do mesmo item.	
 */     
