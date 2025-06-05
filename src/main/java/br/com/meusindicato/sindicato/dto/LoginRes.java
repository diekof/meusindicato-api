package br.com.meusindicato.sindicato.dto;

public class LoginRes {
    private String username;
    private String access_token;
    
    
    
	public LoginRes(String username, String access_token) {
		super();
		this.username = username;
		this.access_token = access_token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

    
  
}