package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.CropDto;
import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.exception.FertilizerNotFoundException;
import com.betrybe.agrix.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class: Crop Controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {
  private final CropService cropService;

  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Method getAllCrops.
   */
  @GetMapping
  @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
  public List<CropDto> getAllCrops() throws CropNotFoundException {
    List<Crop> allCrops = cropService.getAllCrops();
    return allCrops.stream()
            .map(CropDto::fromEntity)
            .toList();
  }

  /**
    Method findCropById.
   */
  @GetMapping("/{id}")
  public CropDto findCropById(@PathVariable Long id) throws CropNotFoundException {
    return CropDto.fromEntity(
            cropService.findCropById(id)
    );
  }

  /**
   * Method findCropByHarvestDate.
   */
  @GetMapping("/search")
  public List<CropDto> findCropByHarvestDate(
          @RequestParam LocalDate start,
          @RequestParam LocalDate end
  ) {
    List<Crop> crops = cropService.findCropByHarvestDate(start, end);

    return crops.stream()
            .map(CropDto::fromEntity)
            .toList();
  }

  /**
   * Method getFertilizerById.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String addCropFertilizer(@PathVariable Long cropId,
                                  @PathVariable Long fertilizerId)
          throws CropNotFoundException, FertilizerNotFoundException {
    cropService.addCropFertilizer(cropId, fertilizerId);

    return "Fertilizante e plantação associados com sucesso!";
  }

  /**
   * Method getFertilizerByCropId.
   */
  @GetMapping("/{cropId}/fertilizers")
  public List<FertilizerDto> getFertilizerByCropId(@PathVariable Long cropId)
        throws CropNotFoundException {
    List<Fertilizer> fertilizers = cropService.getFertilizerByCropId(cropId);

    return fertilizers.stream()
              .map(FertilizerDto::fromEntity)
              .toList();
  }
}