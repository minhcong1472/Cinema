package Ptit.Cinema.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Ptit.Cinema.model.ChucVu;
import Ptit.Cinema.model.NhanVien;
import Ptit.Cinema.repository.NhanVienRepository;

@Service
public class NhanVienServiceImpl implements NhanVienService {
private NhanVienRepository nvRepository;
	
	public NhanVienServiceImpl(NhanVienRepository userRepository) {
		super();
		this.nvRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		NhanVien nv = nvRepository.findByEmail(username);
		if(nv == null) {
			throw new UsernameNotFoundException("Sai tên tài khoản hoặc mật khẩu.");
		}
		return new org.springframework.security.core.userdetails.User(nv.getEmail(), nv.getPassword(), mapRolesToAuthorities(nv.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<ChucVu> chucvus){
		return chucvus.stream().map(chucvu -> new SimpleGrantedAuthority(chucvu.getName())).collect(Collectors.toList());
	}
	
}
