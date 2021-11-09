package Ptit.Cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Ptit.Cinema.dto.LichChieuDTO;
import Ptit.Cinema.model.LichChieu;
import Ptit.Cinema.service.LichChieuService;
import Ptit.Cinema.service.PhimService;
import Ptit.Cinema.service.PhongService;
import Ptit.Cinema.service.RapService;

@Controller
public class AdminController {

	@Autowired
	RapService rapService;
	@Autowired
	PhongService phongService;
	@Autowired
	PhimService phimService;
	@Autowired
	LichChieuService lichchieuService;

	@Autowired

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String home() {
		return "GDQuanLy";
	}

	@GetMapping("/admin")
	public String adminHome() {
		return "GDChonQuanLyLichChieu";
	}

	@GetMapping("/admin/lichchieu")
	public String getShowTimes(Model model, @Param("keyword") String keyword) {
		List<LichChieu> lichchieu = lichchieuService.getAllShowTimes(keyword);
		model.addAttribute("lichchieu", lichchieu);
		model.addAttribute("keyword", keyword);
		return "GDLichChieu";
	}

	@PostMapping("/admin/lichchieu/add")
	public String saveShowTimes(@ModelAttribute("lichChieuDTO") LichChieuDTO lichChieuDTO) {

		LichChieu lichchieu = new LichChieu();
		
		lichchieu.setId(lichChieuDTO.getId());
		lichchieu.setPhim(phimService.getMovieById(lichChieuDTO.getPhimId()).get());
		lichchieu.setPhong(phongService.getRoomById(lichChieuDTO.getPhimId()).get());
		lichchieu.setGiave(lichChieuDTO.getGiave());
		lichchieu.setThoigianchieu(lichChieuDTO.getThoigianchieu());

		lichchieuService.saveShowTimes(lichchieu);
		return "redirect:/admin/lichchieu";
	}

	@GetMapping("/admin/lichchieu/delete/{id}")
	public String deleteShowTimes(@PathVariable int id) {
		lichchieuService.removeShowTimes(id);
		return "redirect:/admin/lichchieu";
	}

	@GetMapping("/admin/lichchieu/update/{id}")
	public String getShowTimesId(@PathVariable int id, Model model) {
		LichChieu lichchieu = lichchieuService.getShowTimesById(id).get();
		LichChieuDTO lichChieuDTO = new LichChieuDTO();
		lichChieuDTO.setId(lichchieu.getId());
		lichChieuDTO.setPhimId(lichchieu.getPhim().getId());
		lichChieuDTO.setPhongId(lichchieu.getPhong().getId());
		lichChieuDTO.setGiave(lichchieu.getGiave());
		lichChieuDTO.setThoigianchieu(lichchieu.getThoigianchieu());

		model.addAttribute("phims", phimService.getAllMovie());
		model.addAttribute("phongs", phongService.getAllRoom());
		model.addAttribute("lichChieuDTO", lichChieuDTO);

		return "GDSuaLichChieu";
	}
}
