package com.betrybe.agrix.exception;

/**
 * Class FertilizerNotFoundException.
 */
public class FertilizerNotFoundException extends NotFoundException {
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
