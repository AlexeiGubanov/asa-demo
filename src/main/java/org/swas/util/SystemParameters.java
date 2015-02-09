package org.swas.util;

import java.util.ResourceBundle;

public class SystemParameters {

  private static final ResourceBundle PARAMETERS;

  public static final String LOCALE;

  static {
    PARAMETERS = ResourceBundle.getBundle("properties.system");
    LOCALE = getParam("locale");
  }

  public static String getParam(String name) {
    return PARAMETERS.getString(name);
  }
}
