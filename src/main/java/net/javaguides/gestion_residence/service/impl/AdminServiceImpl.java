package net.javaguides.gestion_residence.service.impl;

import net.javaguides.gestion_residence.dto.AdminDto;
import net.javaguides.gestion_residence.entity.Admin;
import net.javaguides.gestion_residence.mapper.AdminMapper;
import net.javaguides.gestion_residence.repository.AdminRepository;
import net.javaguides.gestion_residence.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public AdminDto authenticateAdmin(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            return AdminMapper.toDto(admin);
        }
        return null;
    }

    @Override
        public Admin addAdmin(Long id, String password, String email) {
        if (adminRepository.findByIdAdmin(id) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (password == null) {
            throw new IllegalArgumentException("password is null");
        }
        Admin admin = new Admin();
        admin.setIdAdmin(id);
        admin.setPassword(password);
        admin.setEmail(email);
        return adminRepository.save(admin);
    }

//
//    @Override
//    public List<Admin> getAllAdmins() {
//        return List.of();
//    }
//
//    @Override
//    public Optional<Admin> getAdminById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Admin saveAdmin(Admin admin) {
//        return null;
//    }
//
//    @Override
//    public void deleteAdmin(Long id) {
//
//    }
}
