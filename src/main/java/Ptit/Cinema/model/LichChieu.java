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
@Table(name="lichchieu")
public class LichChieu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private double giave;
	
	private String thoigianchieu;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="phim_id",referencedColumnName = "id")
	private Phim phim;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="phong_id",referencedColumnName = "id")
	private Phong phong;
	
}
