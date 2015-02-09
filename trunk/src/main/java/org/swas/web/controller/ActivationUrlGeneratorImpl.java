package org.swas.web.controller;

import org.swas.domain.User;
import org.swas.service.ActivationUrlGenerator;
import org.swas.util.SystemParameters;
import org.swas.web.helper.UrlHelper;

import javax.servlet.http.HttpServletRequest;

/**
* @author gvaysh@gmail.com
* @date 09-02-2015.
*/
public class ActivationUrlGeneratorImpl implements ActivationUrlGenerator {
  private HttpServletRequest request;

  public ActivationUrlGeneratorImpl(HttpServletRequest request) {
    this.request = request;
  }

  public String generateUrl(User user) {
    String template = SystemParameters.getParam("accountActivation.url");
    String serverName = request.getServerName();
    if (request.getServerPort() != 80) {
      serverName += ":" + request.getServerPort();
    }
    template = template.replaceAll("\\{server\\}", serverName);
    template = template.replaceAll("\\{context\\}", request.getContextPath());
    template = template.replaceAll("\\{activateUrl\\}", UrlHelper.URL_ACTIVATE);
    template = template.replaceAll("\\{activationCode\\}", user.getActivationCode());
    return template;
  }
}
