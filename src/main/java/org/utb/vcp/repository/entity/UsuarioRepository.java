package org.utb.vcp.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utb.vcp.model.entity.Usuario;
import java.util.Optional;


@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByUsernameAndCodEstado(String username, String codEstado);
    Boolean existsByUsername(String username);
    Boolean existsByEmailUsuario(String emailUsuario);
}
