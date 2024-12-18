package org.utb.vcp.model.payload.request;

import java.util.Set;

import org.utb.vcp.model.entity.Persona;

public class SignUpRequest {

  private String username;

  private String email;

  private Set<String> role;

  private String password;

  private Persona persona;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<String> getRole() {
    return role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Persona getPersona() {
    return persona;
  }

  public void setPersona(Persona persona) {
    this.persona = persona;
  }

  @Override
  public String toString() {
    return "SignUpRequest [username=" + username + ", email=" + email + ", role=" + role + ", password=" + password
        + ", persona=" + persona + "]";
  }

}
