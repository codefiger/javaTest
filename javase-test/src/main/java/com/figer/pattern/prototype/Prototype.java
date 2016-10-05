package com.figer.pattern.prototype;

import java.io.Serializable;

/**
 * Created by figer on 10/5/16.
 */
public interface Prototype extends Cloneable, Serializable {
  Prototype clone();
  Prototype deepClone();
}
