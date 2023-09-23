package ch.csbe.backendlb.resources.login;

import ch.csbe.backendlb.resources.user.UserEntitie;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Custom user details implementation for use with Spring Security.
 */
@Data
public class MyUserPrincipal implements UserDetails {
    private UserEntitie user;

    /**
     * Constructor to create a MyUserPrincipal instance from a UserEntity.
     *
     * @param userEntity The UserEntity from which to create the principal.
     */
    public MyUserPrincipal(UserEntitie userEntity) {
        this.user = userEntity;
    }

    /**
     * Get the authorities (roles) associated with the user.
     *
     * @return A collection of GrantedAuthority objects representing the user's roles.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String privilege : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }

    /**
     * Get the user's password.
     *
     * @return The user's password.
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Get the user's username.
     *
     * @return The user's username.
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Check if the user's account is not expired.
     *
     * @return True if the account is not expired; otherwise, false.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true; // Modify as needed
    }

    /**
     * Check if the user's account is not locked.
     *
     * @return True if the account is not locked; otherwise, false.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true; // Modify as needed
    }

    /**
     * Check if the user's credentials are not expired.
     *
     * @return True if the credentials are not expired; otherwise, false.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Modify as needed
    }

    /**
     * Check if the user's account is enabled.
     *
     * @return True if the account is enabled; otherwise, false.
     */
    @Override
    public boolean isEnabled() {
        return true; // Modify as needed
    }

    /**
     * Set the user's email address.
     *
     * @param email The user's email address.
     */
    public void setEmail(String email) {
        this.user.setEmail(email);
    }
}
