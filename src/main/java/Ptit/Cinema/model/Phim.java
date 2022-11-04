package Ptit.Cinema.model;


import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="phim")
public class Phim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String ten;

	private String theloai;

	private String namsanxuat;

	private String mota;

	private String tenanh;
	
	private Time thoiluong;
	
}
