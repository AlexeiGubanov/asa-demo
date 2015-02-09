package org.swas.service;

import java.util.Locale;
import java.util.Map;

public interface TmplMerger {

  String TMPL_USER_ACTIVATION = "tmpl.activation";
  String TMPL_USER_PASSWORD_RESTORE = "tmpl.passwordRestore";


  String mergeTemplate(String tmplName, Map model, Locale locale);


}
