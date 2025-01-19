package net.javaguides.gestion_residence.service;

import net.javaguides.gestion_residence.dto.AdminDto;
import net.javaguides.gestion_residence.entity.Admin;
import org.springframework.stereotype.Service;


public interface AdminService {
    AdminDto authenticateAdmin(String email, String password);

    Admin addAdmin(Long id, String password,String email);


//     List<Admin> getAllAdmins();
//
//     Optional<Admin> getAdminById(Long id);
//
//     Admin saveAdmin(Admin admin) ;
//
//     void deleteAdmin(Long id);

    
}
