package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.exception.FertilizerNotFoundException;
import com.betrybe.agrix.repository.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class: FertilizerService.
 */
@Service
public class FertilizerService {
  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Method: createFertilizer.
   */
  public Fertilizer createFertilizer(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  /**
   * Method: getAllFertilizer.
   */
  public List<Fertilizer> getAllFertilizer() {
    return fertilizerRepository.findAll();
  }

  /**
   * Method getFertilizerById.
   */
  public Fertilizer getFertilizerById(Long id) throws FertilizerNotFoundException {
    return fertilizerRepository.findById(id)
            .orElseThrow(FertilizerNotFoundException::new);
  }
}
