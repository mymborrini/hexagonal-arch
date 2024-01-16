package dev.skynet.alpha.exceptions;

import lombok.Getter;

@Getter
public class ItemNotFoundException extends RuntimeException {

  private final String message;

  public ItemNotFoundException(String format, Object... arguments) {
    super(format);
    this.message = String.format(format, arguments);
  }

}
