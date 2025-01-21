package net.javaguides.gestion_residence.service;
import net.javaguides.gestion_residence.dto.ChambreDto;
import net.javaguides.gestion_residence.entity.Chambre;

import java.util.List;
import java.util.Map;


public interface ChambreService {

    ChambreDto saveChambre(ChambreDto chambreDto);
    ChambreDto getChambre(Long id);
    List<ChambreDto> getAvailableChambres();
    List<ChambreDto> getAllChambres();
    ChambreDto updateChambre(Long id, ChambreDto chambreDto);
    void deleteChambre(Long id);
    void assignResidentToChambre(long chambreId, long residentId);

    Map<String, Object> getChambreStatistics();

//    Chambre libererChambre(Long chambreId);
}
