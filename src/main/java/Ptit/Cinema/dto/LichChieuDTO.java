package Ptit.Cinema.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class LichChieuDTO {

	private int id;

	private double giave;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp thoigianchieu;
	
	private Timestamp thoigianketthuc;

	private int phimId;

	private int phongId;
}
