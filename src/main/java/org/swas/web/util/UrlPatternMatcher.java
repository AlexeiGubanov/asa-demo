package org.swas.web.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface that allows to check url is matches certain rules.
 */
public interface UrlPatternMatcher {

  /**
   * Check that url string matches.
   *
   * @param path - string url
   * @return true if matches
   */
  boolean isMatch(String path);

  /**
   * Check that request url matches.
   *
   * @param request - request
   * @return true if matches
   */
  boolean isMatch(HttpServletRequest request);
}
