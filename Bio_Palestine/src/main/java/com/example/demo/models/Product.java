package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="products")
public class Product {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull(message="Must be not null")
	    @Size(min=3,message="Neme Product must be at leaste three character")
	    private String productName;
	    
	    @NotNull(message="Must be not null")
	    @Min(value = 1)
	    private Double productPrice;
	    
	    @NotNull(message="Must be not null")
	    @Size(min=5)
	    private String productFact;
	    
	    @NotNull(message="Must be not null")
	    @Size(min=3)
	    private String productAvailbilty;

	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    
		public Product() {
			
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getProductName() {
			return productName;
		}


		public void setProductName(String productName) {
			this.productName = productName;
		}


		public Double getProductPrice() {
			return productPrice;
		}


		public void setProductPrice(Double productPrice) {
			this.productPrice = productPrice;
		}


		public String getProductFact() {
			return productFact;
		}


		public void setProductFact(String productFact) {
			this.productFact = productFact;
		}


		public String getProductAvailbilty() {
			return productAvailbilty;
		}


		public void setProductAvailbilty(String productAvailbilty) {
			this.productAvailbilty = productAvailbilty;
		}
	    
//	    @Lob
//	    @Column(name="product_picture")
//	    ByteArray productPicture;
	    
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
		
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
}
