package Ptit.Cinema.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name =  "nhanvien", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class NhanVien {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	
	private String password;
	
	@Getter
	@Setter
	private String hoten;
	
	@Getter
	@Setter
	private String diachi;
	
	@Getter
	@Setter
	private Date ngaysinh;
	
	@Getter
	@Setter
	private int sdt;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "nhanvien_chucvu",
	joinColumns = @JoinColumn( name = "nhanvien_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn( name = "chucvu_id", referencedColumnName = "id"))
	private Collection<ChucVu> chucvus;
	
	public NhanVien() {
		
	}
	
	public NhanVien( String email, String password, Collection<ChucVu> chucvus) {
		super();

		this.email = email;
		this.password = password;
		this.chucvus = chucvus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Collection<ChucVu> getRoles() {
		return chucvus;
	}
	public void setRoles(Collection<ChucVu> chucvus) {
		this.chucvus = chucvus;
	}
	
}
