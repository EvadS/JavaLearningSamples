package com.javacodegeeks.ejbsecurity;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;
import java.util.concurrent.Callable;

@Stateless
@RunAs("User")
@PermitAll
public class UserHandler {
    public <V> V call(Callable<V> callable) throws Exception {
        return callable.call();
    }
}
