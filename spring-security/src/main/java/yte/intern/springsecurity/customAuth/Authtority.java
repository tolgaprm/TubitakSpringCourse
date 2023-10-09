package yte.intern.springsecurity.customAuth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Authtority implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;

    private String authority;
}
