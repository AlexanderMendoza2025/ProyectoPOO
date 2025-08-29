package org.example.ProyectoPOO.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@View(name = "Factura", members = "nombreProducto, costoUnidad;")
/***
 * @author Alexander Mendoza, Joseph Aleman
 * Clase @code{Producto}, almancena los datos de los productos guardados en el inventario de la base de datos.
 */
public class Producto {
    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idProducto")
    /***
     * @param idProducto
     * Identificador unico para cada producto
     */
    private String idProducto;

    @Column(name = "nombreProducto", nullable = false)
    /***
     * @param nombreProducto
     * ALmacena el nombre de cada producto
     */
    private String nombreProducto;

    @Column(name = "descripcion", length = 512)
    @TextArea
    /***
     * @param descripcionProducto
     * Almacena la descripcion de los productos
     */
    private String descripcionProducto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCategoria")
    @ReferenceView("Simple")
    @NoFrame
    /***
     * @param categoria
     * Relacion con la clase @code{Categoria} que muestra la categoria a la cual pertenece cada producto
     */
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProveedor")
    @ReferenceView("Proveedor")
    @NoFrame
    /***
     * @param proveedor
     * Relacion con la clase @code{Proveedor} que muestra el proveedor del producto
     */
    private Proveedor proveedor;

    @Column(name = "stock", nullable = false)
    @Required(message = "Ingrese una catidad")
    /***
     * @param stock
     * Muestra las existencias de cada producto
     */
    private int stock;

    @Column(name = "precio", nullable = false)
    @Required(message = "Digite el precio")
    @Stereotype("DINERO")
    /***
     * @param costoUnidad
     * Muestra el precio unitario de cada producto
     */
    private BigDecimal costoUnidad;

    @Column(name = "fechaRegistro")
    /***
     * @param fechaRegistro
     * Guarda la fecha en la cual se realiza el registro
     */
    private LocalDate fechaRegistro = LocalDate.now();

//    @PrePersist
//    @PreUpdate
//    public void ValidarStock(){
//        if (this.stock <= 5){
//            throw new ValidationException("El stock del producto '" + this.nombreProducto +
//                    "' es bajo. Stock actual: " + this.stock + ", mínimo: 5");
//        }
//    }

    @Override
    public String toString() {
        return nombreProducto;
    }
}
