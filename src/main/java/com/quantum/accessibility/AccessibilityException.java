package com.quantum.accessibility;

public class AccessibilityException extends PerfectoRuntimeException {
  private static final long serialVersionUID = 1L;

  public AccessibilityException(String reason) {
    super(reason);
  }
}
