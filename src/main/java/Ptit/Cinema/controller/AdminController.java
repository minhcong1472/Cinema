package Ptit.Cinema.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Ptit.Cinema.dto.LichChieuDTO;
import Ptit.Cinema.model.LichChieu;
import Ptit.Cinema.model.Phim;
import Ptit.Cinema.repository.LichChieuRepository;
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
    LichChieuRepository lcRepo;

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
    public String getLichChieu(Model model, @Param("keyword") String keyword) {
        List<LichChieu> lichchieu = lichchieuService.getAllLichChieu(keyword);
        model.addAttribute("lichchieu", lichchieu);
        model.addAttribute("keyword", keyword);
        return "GDLichChieu";
    }

    @GetMapping("admin/lichchieu/add")
    public String addLichChieuPage(Model model){
        LichChieuDTO lichChieuDTO = new LichChieuDTO();
        model.addAttribute("phims", phimService.getAllMovie());
        model.addAttribute("phongs", phongService.getAllRoom());
        model.addAttribute("lichChieuDTO", lichChieuDTO);

        return "GDThemLichChieu";
    }

    @GetMapping("/admin/lichchieu/delete/{id}")
    public String deleteLichChieu(@PathVariable int id, RedirectAttributes redirect) {
        Optional<LichChieu> lichChieu = lichchieuService.getLichChieuTheoId(id);
        if (!lichChieu.isPresent()) {
            redirect.addFlashAttribute("delete_fail", "Không thể tìm thấy Lịch Chiếu");
            return "redirect:/admin/lichchieu";
        }

        lichchieuService.removeShowTimes(id);
        return "redirect:/admin/lichchieu";
    }

    @GetMapping("/admin/lichchieu/update/{id}")
    public String getLichChieuTheoID(@PathVariable int id, Model model, RedirectAttributes redirect) {
        Optional<LichChieu> lichchieu = lichchieuService.getLichChieuTheoId(id);
        if (!lichchieu.isPresent()) {
            redirect.addFlashAttribute("id_notfound", "Không thể tìm thấy Lịch Chiếu");
            return "redirect:/admin/lichchieu";
        }
        LichChieuDTO lichChieuDTO = new LichChieuDTO();
        lichChieuDTO.setId((lichchieu.get().getId()));
        lichChieuDTO.setPhimId((lichchieu.get()).getPhim().getId());
        lichChieuDTO.setPhongId((lichchieu.get()).getPhong().getId());
        lichChieuDTO.setGiave((lichchieu.get()).getGiave());
        lichChieuDTO.setThoigianchieu((lichchieu.get()).getThoigianchieu());
        lichChieuDTO.setThoigianketthuc((lichchieu.get()).getThoigianketthuc());
        model.addAttribute("phims", phimService.getAllMovie());
        model.addAttribute("phongs", phongService.getAllRoom());
        model.addAttribute("lichChieuDTO", lichChieuDTO);
        return "GDSuaLichChieu";
    }

    @PostMapping("/admin/lichchieu/save")
    public String saveLichChieu(@ModelAttribute("lichChieuDTO") LichChieuDTO lichChieuDTO, Model model, RedirectAttributes redirect) {
        if(lichChieuDTO.getId() == null){
            lichChieuDTO.setId(0);
        }

        Optional<LichChieu> lichchieucu = lichchieuService.getLichChieuTheoId(lichChieuDTO.getId());

        LichChieu lichchieu = new LichChieu();
        lichchieu.setId(lichChieuDTO.getId());
        lichchieu.setPhim(phimService.getMovieById(lichChieuDTO.getPhimId()).get());
        lichchieu.setPhong(phongService.getRoomById(lichChieuDTO.getPhongId()).get());
        lichchieu.setGiave(lichChieuDTO.getGiave());
        lichchieu.setThoigianchieu(lichChieuDTO.getThoigianchieu());
        lichchieu.setThoigianketthuc(lichChieuDTO.getThoigianketthuc());

        if(lichchieucu.isPresent()){
            if ((lichchieucu.get()).equals(lichchieu)) {
                model.addAttribute("update_notchange", "Thông tin lịch chiếu chưa có gì thay đổi");
                return getLichChieuTheoID(lichChieuDTO.getId(), model, redirect);
            }
        }

        Timestamp batdau = lichChieuDTO.getThoigianchieu();
        Timestamp ketthuc = lichChieuDTO.getThoigianketthuc();
        Optional<Phim> phim = phimService.getMovieById(lichChieuDTO.getPhimId());

        long kt = ketthuc.getTime();
        long bd = batdau.getTime();
        long phutchieu = (kt - bd) / (60 * 1000); // lay so phut cua lich chieu
        int thoiluongphim = chuyenThoiLuongSangPhut((phim.get()).getThoiluong().toString());// lay so phut cua phim

        if (phutchieu < thoiluongphim) { // neu so phut chieu nho hon thoi luong cua phim
            model.addAttribute("update_fail", "Thời gian kết thúc phải lớn hơn hoặc bằng :Thời Gian bắt đầu + Thời lượng của phim");
            return getLichChieuTheoID(lichChieuDTO.getId(), model, redirect);
        }
        Optional<List<LichChieu>> lichchieuTonTai = lcRepo.findLichChieuByRoomAndTimeStartOrTimeEnd(lichChieuDTO.getPhongId(), lichChieuDTO.getThoigianchieu(), lichChieuDTO.getThoigianketthuc());
        // or !(lichchieuTonTai.get()).isEmpty
        if ((!(lichchieuTonTai.get()).isEmpty()) && lichChieuDTO.getId() != ((lichchieuTonTai.get()).get(0).getId())) {
            model.addAttribute("update_fail2", "Phòng đang được sử dụng");
            if(lichChieuDTO.getId() == 0){
                return addLichChieuPage(model);
            }
            return getLichChieuTheoID(lichChieuDTO.getId(), model, redirect);
        }
        lichchieuService.LuuCapNhat(lichchieu);
        if(lichChieuDTO.getId() == 0){
            redirect.addFlashAttribute("update_success", "Thêm mới lịch chiếu thành công");
        }
        redirect.addFlashAttribute("update_success", "Cập nhật thông tin lịch chiếu thành công");
        return "redirect:/admin/lichchieu";
    }

    private int chuyenThoiLuongSangPhut(String s) {
        String[] tachchuoi = s.split(":");
        int gio = Integer.parseInt(tachchuoi[0]);
        int phut = Integer.parseInt(tachchuoi[1]);
        int giosangphut = gio * 60;
        return giosangphut + phut;
    }
}
