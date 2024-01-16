package dev.skynet.alpha.exceptions;


import lombok.Getter;

@Getter
public class MissingBeanException extends RuntimeException{

  private final String message;

  public MissingBeanException(String format, Object... arguments) {
    super(format);
    this.message = String.format(format, arguments);
  }
}
