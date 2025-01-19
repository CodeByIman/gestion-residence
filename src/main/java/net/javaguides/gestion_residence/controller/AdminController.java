
package net.javaguides.gestion_residence.controller;

import net.javaguides.gestion_residence.dto.AdminDto;
import net.javaguides.gestion_residence.dto.LoginRequest;
import net.javaguides.gestion_residence.entity.Admin;
import net.javaguides.gestion_residence.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        AdminDto adminDto = adminService.authenticateAdmin(loginRequest.getEmail(), loginRequest.getPassword());
        if (adminDto != null) {
            return ResponseEntity.ok(adminDto);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }




    @PostMapping("/add")
    public ResponseEntity<String> addAdmin(@RequestBody AdminDto adminRequest) {
        try {
            adminService.addAdmin(adminRequest.getIdAdmin(), adminRequest.getPassword(),adminRequest.getEmail());
            return ResponseEntity.ok("Admin added successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


//    @GetMapping
//    public List<Admin> getAllAdmins() {
//        return adminService.getAllAdmins();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
//        return adminService.getAdminById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Admin createAdmin(@RequestBody Admin admin) {
//        return adminService.saveAdmin(admin);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteAdmin(@PathVariable Long id) {
//        adminService.deleteAdmin(id);
//    }
}
