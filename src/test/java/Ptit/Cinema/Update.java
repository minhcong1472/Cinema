//package Ptit.Cinema;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import javax.transaction.Transactional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
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
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@DataJpaTest
//@Rollback(true)
//
//public class Update {
//
//	@Autowired
//	LichChieuService lichchieuService;
//	@Autowired
//	LichChieuRepository lichchieuRepo;
//
//	@Autowired
//	PhimService phimService;
//	@Autowired
//	PhimRepository phimRepo;
//
//	@Autowired
//	PhongService phongService;
//	@Autowired
//	PhongRepository phongRepo;
//
//	@Autowired
//	TestEntityManager entity;
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
////		Phim savePhim = phimRepo.save(phim1);
////
////		Phim exitsPhim = entity.find(Phim.class, savePhim.getId());
////
////		assertThat(exitsPhim.getId()).isEqualTo(phim1.getId());
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
////		phongRepo.save(phong1);
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
//}
