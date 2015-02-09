package org.swas.web.interceptor;

import javax.servlet.http.HttpServletRequest;

public interface ExcludedUrlsAware {

  /**
   * Check that url string excluded.
   *
   * @param path - string url
   * @return true if excluded
   */
  boolean isExcluded(String path);

  /**
   * Check that request url excluded.
   *
   * @param request - request
   * @return true if excluded
   */
  boolean isExcluded(HttpServletRequest request);

}
