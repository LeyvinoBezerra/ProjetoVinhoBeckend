package br.com.gerenciar.vinho.model;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "usuario", schema = "public")
@SequenceGenerator(name = "public.sq_usuario", sequenceName = "public.sq_usuario", allocationSize = 1)
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.sq_usuario")
    @Column(name = "id", columnDefinition = "NUMERIC", length = 22)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "data_hora")
    private LocalDate dataHora;
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuarios_acesso",
        joinColumns = @JoinColumn(
            name = "usuario_id",
            referencedColumnName = "id",
            table = "usuario",
            foreignKey = @ForeignKey(
                name = "usuario_fk",
                value = ConstraintMode.CONSTRAINT
            )
        ),
        inverseJoinColumns = @JoinColumn(
            name = "acesso_id",
            referencedColumnName = "id",
            table = "acesso",
            foreignKey = @ForeignKey(
                name = "acesso_fk",
                value = ConstraintMode.CONSTRAINT
            )
        )
    )
    private List<Acesso> acessos;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return acessos;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
