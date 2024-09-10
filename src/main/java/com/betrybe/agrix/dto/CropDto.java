package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Crop;
import java.time.LocalDate;

/**
 * Class Type CropDto.
 */
public record CropDto(Long id, Long farmId, String name, Double plantedArea,
                      LocalDate plantedDate, LocalDate harvestDate) {
  /**
   * Constructor FarmDto.
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
            crop.getId(),
            crop.getFarm().getId(),
            crop.getName(),
            crop.getPlantedArea(),
            crop.getPlantedDate(),
            crop.getHarvestDate()
    );
  }
}
