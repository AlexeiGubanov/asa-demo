package org.swas.domain;

public enum UserStatus {
    NEW,
    ACTIVE,
    BLOCKED;

    public static UserStatus forCode(int code) {
        for (UserStatus s : UserStatus.values()) {
            if (s.ordinal() == code)
                return s;
        }
        return null;
    }


}
