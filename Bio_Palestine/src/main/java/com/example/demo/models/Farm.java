package com.example.demo.models;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="farms")
public class Farm {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message="Name must be not null")
	@Size(min=3,max=10,message="Must be at least three character")
	private String farmName;
	
	@NotNull(message="Address must be not null")
	@Size(min=5,max=15,message="Must be at least five character")
	private String farmAddress;
	
	@NotNull(message="Phone must be not null")
	@Min(value=10, message="at least ten number")
	private int farmPhone;
	
	@NotNull(message="Location must be not null")
	@Size(min=5,message="at least five character")
	private String farmLocation;
	
	@NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
	
	@NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
	
	@Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
   
    
    @OneToMany(mappedBy="farm", fetch = FetchType.LAZY)
    private List<Product> productsIncluded;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    
    public List<Role> getRoles() {
		return roles;
	}




	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}




	public Farm() {
    	
	}
    
    
 

	public List<Product> getProductsIncluded() {
		return productsIncluded;
	}




	public void setProductsIncluded(List<Product> productsIncluded) {
		this.productsIncluded = productsIncluded;
	}




	public String getFarmLocation() {
		return farmLocation;
	}

	public void setFarmLocation(String farmLocation) {
		this.farmLocation = farmLocation;
	}


	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFarmName() {
		return farmName;
	}



	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}



	public String getFarmAddress() {
		return farmAddress;
	}



	public void setFarmAddress(String farmAddress) {
		this.farmAddress = farmAddress;
	}



	public int getFarmPhone() {
		return farmPhone;
	}



	public void setFarmPhone(int farmPhone) {
		this.farmPhone = farmPhone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirm() {
		return confirm;
	}



	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public void addproductToFarm(Product product) {
		if(this.productsIncluded==null) {
			this.productsIncluded=new ArrayList<Product>();
		}
		this.productsIncluded.add(product);
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
