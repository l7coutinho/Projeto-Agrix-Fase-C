package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.exception.FertilizerNotFoundException;
import com.betrybe.agrix.repository.CropRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class: Crop Service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FertilizerService fertilizerService;

  @Autowired
  public CropService(CropRepository cropRepository, FertilizerService fertilizerService) {
    this.cropRepository = cropRepository;
    this.fertilizerService = fertilizerService;
  }

  /**
   * Method listAllCrops.
   */
  public List<Crop> getAllCrops() throws CropNotFoundException {
    return cropRepository.findAll();
  }

  /**
   * Method findCropById.
   */
  public Crop findCropById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id)
            .orElseThrow(CropNotFoundException::new);
  }

  /**
   * Method findCropByHarvestDate.
   */
  public List<Crop> findCropByHarvestDate(LocalDate start, LocalDate end) {
    return cropRepository.getByHarvestDateBetween(start, end);
  }

  /**
   * Method addCropFertilizer.
   */
  public void addCropFertilizer(Long cropId, Long fertilizerId)
          throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = findCropById(cropId);
    Fertilizer fertilizer = fertilizerService.getFertilizerById(fertilizerId);

    crop.getFertilizers().add(fertilizer);

    cropRepository.save(crop);
  }

  /**
   * Method getFertilizerByCropId.
   */
  public List<Fertilizer> getFertilizerByCropId(Long cropId) throws CropNotFoundException {
    Crop crop = findCropById(cropId);

    return crop.getFertilizers();
  }
}