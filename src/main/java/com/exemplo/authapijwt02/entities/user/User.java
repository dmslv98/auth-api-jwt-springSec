package com.exemplo.authapijwt02.entities.user;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

//import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import com.exemplo.authapijwt02.entities.user.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Table(name = "users")
@Entity(name = "users")
public class User implements UserDetails {
	
	@Id
	@GeneratedValue (strategy =  GenerationType.UUID)
	private String id;
	
	private String login;
	private String password;
	//private String role;
	private UserRole role;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String login, String password, UserRole role){
        this.login = login;
        this.password = password;
        this.role = role;
    }

	public User(String id, String login, String password, UserRole role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		//return null;
		if(this.role == UserRole.ADMIN) 
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), 
					       new SimpleGrantedAuthority("ROLE_USER")
					      );
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
