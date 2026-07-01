package com.tugas.docker.controller;

import com.tugas.docker.model.Mahasiswa;
import com.tugas.docker.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private static final String NIM = "20220140054";
    private static final List<Mahasiswa> DATA_MAHASISWA = new ArrayList<>();

    @GetMapping({"/", "/login"})
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("nim", NIM);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session, RedirectAttributes redirectAttributes) {
        if ("admin".equals(user.getUsername()) && NIM.equals(user.getPassword())) {
            session.setAttribute("login", true);
            session.setAttribute("username", user.getUsername());
            return "redirect:/home";
        }
        redirectAttributes.addFlashAttribute("error", "Username atau password salah. Gunakan username admin dan password NIM.");
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }
        model.addAttribute("nim", NIM);
        model.addAttribute("namaWebsite", "Tugas Docker 20220140054");
        model.addAttribute("dataMahasiswa", DATA_MAHASISWA);
        model.addAttribute("jumlahData", DATA_MAHASISWA.size());
        return "home";
    }

    @GetMapping("/form")
    public String form(HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }
        model.addAttribute("mahasiswa", new Mahasiswa());
        model.addAttribute("nim", NIM);
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@RequestParam String nama,
                             @RequestParam String nim,
                             @RequestParam String jenisKelamin,
                             @RequestParam String alamat,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }
        int nomor = DATA_MAHASISWA.size() + 1;
        DATA_MAHASISWA.add(new Mahasiswa(nomor, nama, nim, jenisKelamin, alamat));
        redirectAttributes.addFlashAttribute("success", "Data mahasiswa berhasil ditambahkan.");
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    private boolean isLoggedIn(HttpSession session) {
        Object login = session.getAttribute("login");
        return login instanceof Boolean && (Boolean) login;
    }
}
