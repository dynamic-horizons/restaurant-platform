package net.dynamichorizons.rp.domain;

import java.io.Serializable;

public class LoginRequest
    implements Serializable
{

    private static final long serialVersionUID = -4100133515254370964L;

    private String username;

    private String password;

    private boolean rememberMe;

    public LoginRequest()
    {
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public boolean isRememberMe()
    {
        return rememberMe;
    }

    public void setRememberMe( boolean rememberMe )
    {
        this.rememberMe = rememberMe;
    }

}
