package dev.skynet.alpha.exceptions;

import lombok.Getter;

@Getter
public class ItemAlreadyExistsException extends RuntimeException {

  private final String message;

  public ItemAlreadyExistsException(String format, Object... arguments) {
    super(format);
    this.message = String.format(format, arguments);
  }

}
