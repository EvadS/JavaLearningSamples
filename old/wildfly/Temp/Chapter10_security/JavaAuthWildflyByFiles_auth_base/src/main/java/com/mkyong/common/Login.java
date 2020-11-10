package com.mkyong.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Login {

    private FacesContext fCtx;

    public Login() {
        fCtx = FacesContext.getCurrentInstance();
    }
}