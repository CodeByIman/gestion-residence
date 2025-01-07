package net.javaguides.gestion_residence.service;
import net.javaguides.gestion_residence.dto.ChambreDto;
import net.javaguides.gestion_residence.entity.Chambre;

import java.util.List;


public interface ChambreService {

    ChambreDto saveChambre(ChambreDto chambreDto);
    ChambreDto getChambre(Long id);
    List<ChambreDto> getAvailableChambres();
    List<ChambreDto> getAllChambres();
    ChambreDto updateChambre(Long id, ChambreDto chambreDto);
    void deleteChambre(Long id);
    void assignResidentToChambre(long chambreId, long residentId);

//    Chambre libererChambre(Long chambreId);
}
