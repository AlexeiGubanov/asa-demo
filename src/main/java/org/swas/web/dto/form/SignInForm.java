package org.swas.web.dto.form;

import org.hibernate.validator.constraints.NotBlank;


public class SignInForm extends ReCaptchaAwareForm {

  @NotBlank
  //(message = "{signIn.emptyLogin}")
  private String login;
  @NotBlank
  private String password;

  private String fromUrl;

  private String redirectTo;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFromUrl() {
    return fromUrl;
  }

  public void setFromUrl(String fromUrl) {
    this.fromUrl = fromUrl;
  }

  public String getRedirectTo() {
    return redirectTo;
  }

  public void setRedirectTo(String redirectTo) {
    this.redirectTo = redirectTo;
  }

  @Override
  public String toString() {
    return "SignInForm{" +
            "login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", fromUrl='" + fromUrl + '\'' +
            ", redirectTo='" + redirectTo + '\'' +
            '}';
  }
}
