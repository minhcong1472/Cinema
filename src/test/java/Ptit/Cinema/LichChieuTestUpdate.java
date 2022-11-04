//package Ptit.Cinema;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.persistence.EntityManager;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.data.repository.query.Param;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import Ptit.Cinema.model.LichChieu;
//import Ptit.Cinema.model.Phim;
//import Ptit.Cinema.model.Phong;
//import Ptit.Cinema.model.Rap;
//import Ptit.Cinema.repository.LichChieuRepository;
//import Ptit.Cinema.repository.PhimRepository;
//import Ptit.Cinema.repository.PhongRepository;
//import Ptit.Cinema.service.LichChieuService;
//import Ptit.Cinema.service.PhimService;
//import Ptit.Cinema.service.PhongService;
//
//public class LichChieuTestUpdate {
//	@Autowired
//	static LichChieuService lichchieuService;
//	@Autowired
//	static LichChieuRepository lichchieuRepo;
//
//	@Autowired
//	static PhimService phimService;
//	@Autowired
//	static PhimRepository phimRepo;
//
//	@Autowired
//	static PhongService phongService;
//	@Autowired
//	static PhongRepository phongRepo;
//
//	@Autowired
//	static TestEntityManager entity;
//
//	static LichChieu lichchieu1 = new LichChieu();
//	
//	@Test
//	@Transactional
//	public void testADDPhim() {
//
//		Phim phim1 = new Phim();
//		phim1.setId(20);
//		phim1.setMota("AS");
//		phim1.setNamsanxuat("2016");
//		phim1.setTen(" Co Ngoc xinh gai");
//		phim1.setTenanh("Free Guy.jpg");
//		phim1.setTheloai("Hanh Dong");
//
//		Rap rap1 = new Rap();
//		rap1.setId(2);
//		rap1.setDiachi("HCM");
//		rap1.setMota("AS");
//		rap1.setTen("Cinema Ptit");
//
//		Phong phong1 = new Phong();
//		phong1.setId(20);
//		phong1.setMota("AS");
//		phong1.setRap(rap1);
//		phong1.setSoghe(50);
//		phong1.setTen("A3");
//
//		LichChieu lichchieu1 = new LichChieu();
//		lichchieu1.setId(30);
//		lichchieu1.setGiave(50000.0);
//		lichchieu1.setPhim(phim1);
//		lichchieu1.setPhong(phong1);
//		lichchieu1.setThoigianchieu("2021-12-17T12:15");
//		lichchieuRepo.save(lichchieu1);
//		assertThat(lichchieu1.getId()).isEqualTo(30);
//
//	}
//
//	public static Phim TaoMoiPhim() {
//
//		Phim phim1 = new Phim();
//		phim1.setId(20);
//		phim1.setMota("AS");
//		phim1.setNamsanxuat("2016");
//		phim1.setTen(" Co Ngoc xinh gai");
//		phim1.setTenanh("Free Guy.jpg");
//		phim1.setTheloai("Hanh Dong");
//		return phim1;
//	}
//
//	public static Phong TaoMoiPhong() {
//		Phong phong1 = new Phong();
//		phong1.setId(20);
//		phong1.setMota("AS");
//		phong1.setRap(TaoMoiRap());
//		phong1.setSoghe(50);
//		phong1.setTen("A3");
//		return phong1;
//	}
//
//	public static Rap TaoMoiRap() {
//		Rap rap1 = new Rap();
//		rap1.setId(2);
//		rap1.setDiachi("HCM");
//		rap1.setMota("AS");
//		rap1.setTen("Cinema Ptit");
//		return rap1;
//	}
//
//	public static LichChieu TaoMoiLichChieu() {
//
////		LichChieu lichchieu1 = new LichChieu();
//		lichchieu1.setGiave(70000);
//		lichchieu1.setPhim(TaoMoiPhim());
//		lichchieu1.setPhong(TaoMoiPhong());
//		lichchieu1.setThoigianchieu("2021-12-12");
//		return lichchieu1;
//	}
//
//	@Test
//	@Transactional
//	void updateLichChieu() {
////		List<LichChieu> listlichchieu = lichchieuRepo.findAll();
////		LichChieu testLC = listlichchieu.get(listlichchieu.size() - 1);
////		assertThat(testLC.getGiave()).isEqualTo(70000);
////		assertThat(testLC.getPhim()).isEqualTo(TaoMoiPhim());
////		assertThat(testLC.getPhong()).isEqualTo(TaoMoiPhong());
////		assertThat(testLC.getThoigianchieu()).isEqualTo("2021-12-12");
////		 lichchieu1 = lichchieuRepo.findById(30);
////		lichchieu1.setGiave(50000.0);
////		lichchieu1.setPhim(phim1);
////		lichchieu1.setPhong(phong1);
////		lichchieu1.setThoigianchieu("2021-12-17T12:15");
////		lichchieuRepo.save(lichchieu1);
////		assertThat(lichchieu1.getId()).isEqualTo(30);
//		
//	}
//
//}
