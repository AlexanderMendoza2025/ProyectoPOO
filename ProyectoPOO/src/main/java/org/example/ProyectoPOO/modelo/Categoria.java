package org.example.ProyectoPOO.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.NoFrame;
import org.openxava.annotations.TextArea;
import org.openxava.annotations.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@View(name = "Simple", members = "nombreCategoria;")
/***
 * @author Alexander Mendoza, Joseph Aleman
 * Clase @code{Categoria}, almacena todos los datos relevantes sobre cada una de las categorias de los productos
 */
public class Categoria {
    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idCategoria")
    /**
     * @param idCategoria
     * Identificador unico de cada categoria
     */
    private String idCategoria;

    @Column(name = "nombreCategoria", length = 50, nullable = false)
    /**
     * @param nombreCategoria
     * Almacena el nombre de cada categoria
     */
    private String nombreCategoria;

    @Column(name = "descripCategoria")
    @TextArea
    /**
     * @param descripcionCategoria
     * Almacena una descripcion corta de cada categoria
     */
    private String descripcionCategoria;

    @Override
    public String toString() {
        return nombreCategoria;
    }
}
