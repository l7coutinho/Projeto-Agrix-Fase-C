package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Fertilizer;

/**
 * Class Type FertilizerDto.
 */
public record FertilizerDto(Long id, String name, String brand, String composition) {

  /**
   * Constructor FertilizerDto.
   */
  public static FertilizerDto fromEntity(Fertilizer fertilizer) {
    return new FertilizerDto(
              fertilizer.getId(),
              fertilizer.getName(),
              fertilizer.getBrand(),
              fertilizer.getComposition()
      );
  }
}