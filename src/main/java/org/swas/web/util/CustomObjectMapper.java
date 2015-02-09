package org.swas.web.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class CustomObjectMapper extends ObjectMapper {

  public CustomObjectMapper() {
    this.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false);
  }
}
