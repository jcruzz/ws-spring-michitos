package org.utb.vcp.repository.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.utb.vcp.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    List<User> findAll();

    User findByIdUsuario(Long idUsuario);

    @Query(value = """
            select
            	fu.id_usuario as id_usuario,
            	fu.username as nombre_usuario,
            	pp.nombres || ' ' || pp.apellido_paterno || ' ' || pp.apellido_materno as nombre_completo,
            	fr.nombre_rol
            from e_web_shop.f_usuario fu
            join e_web_shop.f_r_usuario_rol frur
            	on frur.id_usuario = fu.id_usuario
            join e_web_shop.f_rol fr
            	on frur.id_rol = fr.id_rol
            join e_web_shop.p_persona pp
            	on fu.id_persona = pp.id_persona
            where fr.nombre_rol = 'ROLE_MODERATOR'
            and fu.cod_estado = 'ACT'
                        """, nativeQuery = true)
    List<Object[]> obtenerUsuariosPorRol();
}
