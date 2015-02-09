package org.swas.web.util;

import java.util.Map;

public class MapValueExtractor implements ValueExtractor {

  private Map<String, ?> map;

  public MapValueExtractor(Map<String, ?> map) {
    if (map == null)
      throw new IllegalStateException("Param 'map' can't be null");
    this.map = map;
  }

  public Object extractValue(String name) {
    return map.get(name);
  }


}
