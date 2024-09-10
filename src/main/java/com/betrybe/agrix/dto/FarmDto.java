package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Farm;

/**
 * Class Type FarmDto.
 */
public record FarmDto(Long id, String name, Double size) {
  /**
   * Constructor FarmDto.
   */
  public static FarmDto fromEntity(Farm farm) {
    return new FarmDto(
            farm.getId(),
            farm.getName(),
            farm.getSize()
    );
  }
}