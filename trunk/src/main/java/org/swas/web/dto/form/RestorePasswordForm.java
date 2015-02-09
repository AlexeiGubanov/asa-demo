package org.swas.web.dto.form;

import org.hibernate.validator.constraints.NotBlank;

public class RestorePasswordForm {

    @NotBlank
    private String identity;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
