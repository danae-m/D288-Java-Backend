package com.danaem.javad288.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusType {
  CartStatus cartStatus;

  public enum CartStatus {
    pending, ordered, canceled
  }
}
