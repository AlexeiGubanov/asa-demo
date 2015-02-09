package org.swas.domain;

import java.io.Serializable;

public interface Persistable<ID extends Serializable> extends Serializable {
  ID getId();
}
