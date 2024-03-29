package org.swas.web.handler;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.swas.web.util.UrlPatternMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractUrlMatchHandlerExceptionResolver extends AbstractHandlerExceptionResolver {

  private UrlPatternMatcher matcher;

  public void setMatcher(UrlPatternMatcher matcher) {
    this.matcher = matcher;
  }

  @Override
  protected boolean shouldApplyTo(HttpServletRequest request, Object handler) {
    return matcher.isMatch(request);
  }

  @Override
  protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    if (matcher.isMatch(request)) {
      try {
        return doResolveMatchedException(request, response, handler, ex);
      } catch (Exception e) {
        return null;
      }
    }
    return null;
  }

  protected abstract ModelAndView doResolveMatchedException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception;
}
