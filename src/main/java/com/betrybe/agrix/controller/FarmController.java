package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.CropCreationDto;
import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FarmCreationDto;
import com.betrybe.agrix.dto.FarmDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class Type FarmController.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Method Create Farm.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmCreationDto farmDto) {
    return FarmDto.fromEntity(
            farmService.create(farmDto.toEntity())
    );
  }

  /**
   * Method Get all farms.
   */
  @GetMapping
  public List<FarmDto> getAllFarms() {
    List<Farm> allFarms = farmService.findAll();

    return allFarms.stream()
            .map(FarmDto::fromEntity)
            .toList();
  }

  /**
   * Method getFarmById.
   */
  @GetMapping("/{id}")
  public FarmDto getFarmById(@PathVariable Long id) throws FarmNotFoundException {
    return FarmDto.fromEntity(
            farmService.findById(id)
    );
  }

  /**
   * Method createCropById.
   */
  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCropById(
          @PathVariable Long farmId,
          @RequestBody CropCreationDto cropCreationDto) throws FarmNotFoundException {
    return CropDto.fromEntity(
            farmService.createCropById(farmId, cropCreationDto.toEntity())
    );
  }

  /**
   * Method findAllCropsById.
   */
  @GetMapping("/{farmId}/crops")
  public List<CropDto> findAllCropsById(
          @PathVariable Long farmId
  ) throws FarmNotFoundException {
    List<Crop> crops = farmService.findAllCropsById(farmId);

    return crops.stream()
            .map(CropDto::fromEntity)
            .toList();
  }
}