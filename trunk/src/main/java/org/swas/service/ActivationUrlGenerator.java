package org.swas.service;

import org.swas.domain.User;

public interface ActivationUrlGenerator {

  String generateUrl(User user);
}
