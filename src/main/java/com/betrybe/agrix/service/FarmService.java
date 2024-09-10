package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class: Farm Service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  /**
   * Method CreateFarm.
   */

  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   * Method Get all farms list.
   */
  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  /**
   * Method findById.
   */
  public Farm findById(Long id) throws FarmNotFoundException {
    return farmRepository.findById(id)
            .orElseThrow(FarmNotFoundException::new);
  }

  /**
   * Method createCropById.
   */
  public Crop createCropById(Long farmId, Crop crop) throws FarmNotFoundException {
    Farm farm = findById(farmId);

    crop.setFarm(farm);

    return cropRepository.save(crop);
  }

  /**
   * Method findAllCropsById.
   */
  public List<Crop> findAllCropsById(Long farmId) throws FarmNotFoundException {
    Farm farm = findById(farmId);

    return cropRepository.findAll().stream()
            .filter(crop -> farmId.equals(crop.getFarm().getId()))
            .toList();
  }
}