package org.swas.web.zk.vm;

import org.apache.commons.lang3.StringUtils;
import org.swas.domain.User;
import org.swas.service.UserService;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.List;

/**
 * @author gvaysh@gmail.com
 * @date 17-02-2015.
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class UsersViewModel {

  @WireVariable
  private UserService userService;

  private String keyword;
  private List<User> users;
  private User selectedUser;

  public String getKeyword() {
    return keyword;
  }

  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public User getSelectedUser() {
    return selectedUser;
  }

  public void setSelectedUser(User selectedUser) {
    this.selectedUser = selectedUser;
  }

  @Init
  public void init() {
    users = userService.findAll();
  }

  @Command
  @NotifyChange("users")
  public void removeUser(@BindingParam("user") User user) {
    userService.delete(user);
    if (StringUtils.isNotEmpty(keyword)) {
      search();
    } else {
      init();
    }
  }

  @Command
  @NotifyChange("users")
  public void saveUser(@BindingParam("user") User user) {
    userService.save(user);
  }

  @Command
  @NotifyChange("users")
  public void search() {
    users = userService.search(keyword);
  }
}
