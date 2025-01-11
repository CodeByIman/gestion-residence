
package net.javaguides.gestion_residence.mapper;

import net.javaguides.gestion_residence.dto.PaiementDto;
import net.javaguides.gestion_residence.entity.Paiement;
import net.javaguides.gestion_residence.entity.Resident;

public class PaiementMapper {

    // Convertit une entité Paiement en PaiementDto
    public static PaiementDto toDto(Paiement paiement) {
        if (paiement == null) {
            return null;
        }

        PaiementDto dto = new PaiementDto();
        dto.setId(paiement.getId());
        dto.setStatu(paiement.getStatu());
        dto.setMontant(paiement.getMontant());
        dto.setDateLimite(paiement.getDateLimite());

        // Vérifie si le résident est non nul avant de récupérer son ID
        if (paiement.getResident() != null) {
            dto.setResidentId(paiement.getResident().getId());
        }

        return dto;
    }

    // Convertit un PaiementDto en entité Paiement
    public static Paiement toEntity(PaiementDto dto, Resident resident) {
        if (dto == null) {
            return null;
        }

        Paiement paiement = new Paiement();
        paiement.setId(dto.getId());
        paiement.setStatu(dto.getStatu());
        paiement.setMontant(dto.getMontant());
        paiement.setDateLimite(dto.getDateLimite());
        paiement.setResident(resident);

        return paiement;
    }
}
