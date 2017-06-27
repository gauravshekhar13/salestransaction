package com.websystique.springboot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="APP_USER")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="ACCESSORIES", nullable=false)
	private double accessories;
	
	@Column(name= "INTACCESS", nullable = false)
	private boolean intaccess;


	@Column(name="MEDICINE", nullable=false)
	private double medicine;
	
	@Column(name= "INTMED", nullable = false)
	private boolean intmed;

	public double getMedicine() {
		return medicine;
	}

	public void setMedicine(double medicine) {
		this.medicine = medicine;
	}

	public boolean isIntmed() {
		return intmed;
	}

	public void setIntmed(boolean intmed) {
		this.intmed = intmed;
	}

	@Column(name="FOOD", nullable=false)
	private double food;
	
	@Column(name="IMPFOOD", nullable=false)
	private double impfood;
	
	public double getImpfood() {
		return impfood;
	}

	public void setImpfood(double impfood) {
		this.impfood = impfood;
	}

	public double getFood() {
		return food;
	}

	public void setFood(double food) {
		this.food = food;
	}

	@Column(name= "INTFOOD", nullable = false)
	private boolean intfood;

	public boolean isIntfood() {
		return intfood;
	}

	public void setIntfood(boolean intfood) {
		this.intfood = intfood;
	}

	@Column(name="PERFUME", nullable=false)
	private double perfume;
	
	@Column(name="IMPPERFUME", nullable=false)
	private double impperfume;

	public double getImpperfume() {
		return impperfume;
	}

	public void setImpperfume(double impperfume) {
		this.impperfume = impperfume;
	}

	@Column(name= "BOOK", nullable = false)
		private double book;
	
	@Column(name= "INTBOOK", nullable = false)
	private boolean intbook;

	
	@Column(name= "TOTALTAX", nullable = false)
	private double totalTax;
	
	@Column(name= "TOTAL", nullable = false)
	private double total;
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public boolean isIntbook() {
		return intbook;
	}

	public void setIntbook(boolean intbook) {
		this.intbook = intbook;
	}

	public double getBook() {
		return book;
	}

	public void setBook(double book) {
		this.book = book;
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

	public double getPerfume() {
		return perfume;
	}

	public void setPerfume(double perfume) {
		this.perfume = perfume;
	}
	public double getAccessories() {
		return accessories;
	}

	public void setAccessories(double accessories) {
		this.accessories = accessories;
	}

	public boolean isIntaccess() {
		return intaccess;
	}

	public void setIntaccess(boolean intaccess) {
		this.intaccess = intaccess;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (Double.compare(user.perfume, perfume) != 0) return false;
		if(Double.compare(user.accessories,accessories)!=0)return false;
		if (id != null ? !id.equals(user.id) : user.id != null) return false;
		if (name != null ? !name.equals(user.name) : user.name != null) return false;
		if(Double.compare(user.impfood,impfood)!=0)return false;
		if(Double.compare(user.medicine,medicine)!=0)return false;
		return food != 0 ? true : false;
		
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		
		temp = Double.doubleToLongBits(medicine);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		
		temp = Double.doubleToLongBits(accessories);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		
		temp = Double.doubleToLongBits(impfood);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		
		temp = Double.doubleToLongBits(food);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		
		temp = Double.doubleToLongBits(perfume);
		
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", food=" + food
				+ ", salary=" + perfume + ", book=" +book + "]";
	}


}
