package com.betrybe.agrix.exception;

/**
 * Class FarmNotFoundException.
 */
public class FarmNotFoundException extends NotFoundException {
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
