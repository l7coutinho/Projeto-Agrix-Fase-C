package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Crop;
import java.time.LocalDate;

/**
 * Class Type CropCreationDto.
 */
public record CropCreationDto(String name, Double plantedArea,
                              LocalDate plantedDate, LocalDate harvestDate) {
  /**
   * Constructor CropCreationDto.
   */
  public Crop toEntity() {
    return new Crop(name, plantedArea, plantedDate, harvestDate);
  }
}
