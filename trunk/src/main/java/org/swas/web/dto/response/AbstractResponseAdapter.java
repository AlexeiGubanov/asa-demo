package org.swas.web.dto.response;

public abstract class AbstractResponseAdapter<T> {

  protected T target;

  public T getTarget() {
    return target;
  }

  public void setTarget(T target) {
    this.target = target;
  }

  public AbstractResponseAdapter(T target) {
    this.target = target;
  }
}
