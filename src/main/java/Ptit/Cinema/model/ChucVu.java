package Ptit.Cinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chucvu")
public class ChucVu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ten;
	
	public ChucVu() {
		
	}
	
	public ChucVu(String ten) {
		super();
		this.ten = ten;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return ten;
	}
	public void setName(String ten) {
		this.ten = ten;
	}
}
