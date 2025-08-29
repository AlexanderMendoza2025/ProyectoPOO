package org.example.ProyectoPOO.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter @Getter
/***
 * @author Alexander Mendoza, Joseph Aleman
 * Clase @code{Factura}, almacena todos los datos relevantes sobre la facturacion de la venta de productos
 */
public class Factura {

    @Id @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(length = 32)
    /***
     * @param idFactura
     * Identificador unico de cada Factura emitida
     */
    private String idFactura;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @ReferenceView("ClienteSimple")
    @NoFrame
    /***
     * @param cliente
     * Relacion con la clase @code{Cliente} que comparte los datos de los clientes
     */
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    @ReferenceView("Factura")
    @NoFrame
    /***
     * @param producto
     * Relacion con la clase @code{Producto} que comparte los productos existentes para venta
     */
    private Producto producto;

    @Column(name = "Cantidad", nullable = false)
    @Required(message = "Ingrese una cantidad de productos")
    /***
     * @param cantidad
     * Cantidad de productos vendidos a un cliente
     */
    private int cantidad;

    @Column(name = "PrecioTotal")
    @Stereotype("DINERO")
    @Calculation("cantidad * producto.costoUnidad")
    @ReadOnly
    /***
     * @param precioTotal
     * Cantidad total en dinero de los articulos vendidos
     */
    private double precioTotal;

    @Column(name = "FechaRegistro", nullable = false)
    @Required
    /***
     * @param fechaRegistro
     * Almacena la fecha en la que se registro la factura
     */
    private LocalDate fechaRegistro;

    @PrePersist
    @PreUpdate
    /***
     * @param SalidaStock
     * Metodo que resta los articulos vendidos a los articulos existentes.
     */
    public void SalidaStock(){
       producto.setStock(producto.getStock() - cantidad);
    }
}
