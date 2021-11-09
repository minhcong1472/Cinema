package Ptit.Cinema.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="phong")
public class Phong {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String ten;
	
	private int soghe;
	
	private String mota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="rap_id",referencedColumnName = "rap_id")
	private Rap rap;
	

}
