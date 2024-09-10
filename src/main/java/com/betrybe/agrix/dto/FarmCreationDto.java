package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Farm;

/**
 * Class Type FarmCreationDto.
 */
public record FarmCreationDto(String name, Double size) {

  /**
   * Constructor FarmCreationDto.
   */
  public Farm toEntity() {
    return new Farm(name, size);
  }
}