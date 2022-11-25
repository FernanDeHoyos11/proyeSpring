
package com.SpringData.SpringData.repo;

import com.SpringData.SpringData.domin.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

/**
 utilisaremos la clase JpaRepository que es como las de CRUDRepository pero con 
 * algunas mejoras, igualmente le pasamos el objeto o clase, en este caso usuarios,
 * y el tipo de  ID, que en este caso es de tipo Long
 */
public interface UsuarioRepo  extends JpaRepository<usuarios, Long>{
    /**
     * para empezar a configurar la seguridad que va a utilizar spring 
     * con nuestra clasae de UsuarioRepo secesitaremos definir un metodo llamado 
     * findByUsername()
 */
    
    
   public usuarios  findByUsername(String username) ;
     /**
      * una vez que proporcionemos un username srping en automatico va a recuperar un obj de tipo
      * usuario filtrado por el username
 */
}
