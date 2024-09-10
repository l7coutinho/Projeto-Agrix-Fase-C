package com.betrybe.agrix.exception;

/**
 * Class CropNotFoundException.
 */
public class CropNotFoundException extends NotFoundException {
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
