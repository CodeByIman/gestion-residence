package net.javaguides.gestion_residence.mapper;

import net.javaguides.gestion_residence.dto.AdminDto;
import net.javaguides.gestion_residence.entity.Admin;

public class AdminMapper {

    // Méthode pour convertir un Admin en AdminDto
    public static AdminDto toDto(Admin admin) {
        if (admin == null) {
            return null;
        }
        AdminDto adminDto = new AdminDto();
        adminDto.setIdAdmin(admin.getIdAdmin());
        adminDto.setPassword(admin.getPassword());
        adminDto.setEmail(admin.getEmail());
        return adminDto;
    }

    // Méthode pour convertir un AdminDto en Admin
    public static Admin toEntity(AdminDto adminDto) {
        if (adminDto == null) {
            return null;
        }
        Admin admin = new Admin();
        admin.setIdAdmin(adminDto.getIdAdmin());
        admin.setPassword(adminDto.getPassword());
        admin.setEmail(adminDto.getEmail());
        return admin;
    }
}
