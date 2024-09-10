package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Fertilizer;

/**
 * Class type fertilizerCreationDto.
 */
public record FertilizerCreationDto(String name, String brand, String composition) {

  /**
   * Constructor FertilizerCreationDto.
   */
  public Fertilizer toEntity() {
    return new Fertilizer(name, brand, composition);
  }
}