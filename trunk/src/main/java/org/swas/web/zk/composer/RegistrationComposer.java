package org.swas.web.zk.composer;

import org.swas.domain.User;
import org.swas.service.Result;
import org.swas.service.UserService;
import org.swas.web.controller.ActivationUrlGeneratorImpl;
import org.zkoss.util.Locales;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.*;

import javax.servlet.http.HttpServletRequest;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class RegistrationComposer extends SelectorComposer<Component> {

  @WireVariable
  private UserService userService;

  @Wire
  private Button submitButton;

  @Wire
  private Checkbox acceptTermBox;

  @Wire
  private Textbox nameBox;

  @Wire
  private Textbox passwordBox;

  @Wire
  private Textbox emailBox;

  @Wire
  private Radiogroup genderRadio;

  @Wire
  private Datebox birthdayBox;


  @Listen("onCheck = #acceptTermBox")
  public void changeSubmitStatus(){
    if (acceptTermBox.isChecked()){
      submitButton.setDisabled(false);
      submitButton.setImage("/images/submit.png");
    }else{
      submitButton.setDisabled(true);
      submitButton.setImage("");
    }
  }

  @Listen("onClick = #submitButton")
  public void register(){
    HttpServletRequest request = (HttpServletRequest) Executions.getCurrent().getNativeRequest();

    User newUser = new User();
    newUser.setEmail(emailBox.getValue());
    newUser.setLogin(nameBox.getValue());
    newUser.setName(nameBox.getValue());
    newUser.setPsw(passwordBox.getValue());
    //save user input into newUser object
    Result r = userService.register(newUser, Locales.getCurrent(), new ActivationUrlGeneratorImpl(request));
    if (r.isOk()) {
      Messagebox.show("Success", "Error", Messagebox.OK, Messagebox.ERROR);
//      Executions.sendRedirect("/chapter8/login.zul");
      return;
    } else {
      Messagebox.show(r.getMsg(), "Error", Messagebox.OK, Messagebox.ERROR);
      // show errors
    }
  }


}
