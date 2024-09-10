package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.FertilizerCreationDto;
import com.betrybe.agrix.dto.FertilizerDto;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.exception.FertilizerNotFoundException;
import com.betrybe.agrix.service.FertilizerService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class: FertilizerController.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {
  private final FertilizerService fertilizerService;

  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
  * Method createFertilizer.
  */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto createFertilizer(@RequestBody FertilizerCreationDto fertilizerCreationDto) {
    Fertilizer fertilizer = fertilizerService.createFertilizer(fertilizerCreationDto.toEntity());

    return FertilizerDto.fromEntity(fertilizer);
  }

  /**
   * Method getAllFertilizer.
   */
  @GetMapping
  public List<FertilizerDto> getAllFertilizer() {
    List<Fertilizer> fertilizerList = fertilizerService.getAllFertilizer();

    return fertilizerList.stream()
            .map(FertilizerDto::fromEntity)
            .toList();
  }

  /**
   * Method getFertilizerById.
   */
  @GetMapping("/{id}")
  public FertilizerDto getFertilizerById(@PathVariable Long id) throws FertilizerNotFoundException {
    return FertilizerDto.fromEntity(fertilizerService.getFertilizerById(id));
  }
}