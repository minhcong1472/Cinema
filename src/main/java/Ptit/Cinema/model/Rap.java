package Ptit.Cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="rap")
public class Rap {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rap_id")
	private int id;
	
	private String ten;
	
	private String diachi;
	
	private String mota;
	
}
