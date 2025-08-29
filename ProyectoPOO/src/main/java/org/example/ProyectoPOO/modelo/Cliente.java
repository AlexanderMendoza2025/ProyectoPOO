package org.example.ProyectoPOO.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@Getter
@Setter

/***
 * @author Alexander Mendoza, Joseph Aleman
 * Clase @code{cliente}, almacena todos los datos relevantes sobre los clientes
 */
@View(name = "ClienteSimple",members = "nombre, apellido;")
public class Cliente {

    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    /***
     * @param idCliente
     * Identificador unico para cada cliente
     */
    private String idCliente;


    @Column(name = "nombreCliente", length = 25, nullable = false)
    @Required(message = "Ingrese el un nombre")
    /***
     * @param nombre
     * Nombres de los clientes
     */
    private String nombre;


    @Column(name = "apellido", length = 25, nullable = false)
    @Required(message = "Ingrese el un apellido")
    /***
     * @param apellido
     * Apellidos de los Clientes
     */
    private String apellido;


    @Column(name = "telefono", nullable = false)
    @Mask("0000-0000")
    @Required(message = "Ingrese el un telefono")
    /***
     * @param telefono
     * Número de contacto de los clientes
     */
    private String telefono;


    @Column(name = "direccion")
    @TextArea
    /***
     * @param direccion
     * Direccion de los clientes o ubicacion donde realizar la entrega
     */
    private String direccion;


    @Column(name = "correo")
    @Email
    @Required(message = "Ingrese un correo valido")
    /***
     * @param Email
     * Correo Electronico de contacto para los clientes
     */
    private String Email;
}
