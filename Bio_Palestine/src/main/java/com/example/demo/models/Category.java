package com.example.demo.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="categories")
public class Category {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	
	 	@NotNull(message="Must be not null")
	 	@Size(min=3,max=15,message = "Must be at least three charactar")
	 	private String categoryTitle;
	 	
	 	@NotNull(message="Must be not null")
	 	@Size(min=5,max=50,message = "Must be at least five charactar")
	 	private String categoryDescription;
	 	
	 
	 	
	 	@OneToMany(mappedBy="categoryType", fetch=FetchType.LAZY)
	 	private List<Product> products;
	 	
	 	@Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
		public Category() {
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCategoryTitle() {
			return categoryTitle;
		}

		public void setCategoryTitle(String categoryTitle) {
			this.categoryTitle = categoryTitle;
		}

		public String getCategoryDescription() {
			return categoryDescription;
		}

		public void setCategoryDescription(String categoryDescription) {
			this.categoryDescription = categoryDescription;
		}
	 	
		
		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	 
}

