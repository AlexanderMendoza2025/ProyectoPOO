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
@Getter @Setter
@View(name = "Proveedor", members = "nombre,apellido,empresa;")
/***
 * @author Alexander Mendoza, Joseph Aleman
 * Clase @code{Proveedor}, almacena todos los datos relevantes sobre los proveedor
 */
public class Proveedor {

    @Id @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    /***
     * @param idProveedor
     * Identificador unico de cada proveedor
     */
    private String idProveedor;

    @Column(name = "NombreProveedor", length = 20,nullable = false)
    @Required
    /***
     * @param nombre
     * Nombre de cada proveedor
     */
    private String nombre;

    @Column(name = "ApellidoProveedor", length = 20,nullable = false)
    @Required
    /***
     * @param apellido
     * Apellido de cada proveedor
     */
    private String apellido;

    @Column(name = "EmpresaProveedor", length = 30,nullable = false)
    @Required
    /***
     * @param empresa
     * Nombre de la empresa proveedora
     */
    private String empresa;

    @Column(name = "TelefonoProveedor",nullable = false)
    @Required
    /***
     * @param telefono
     * Número de contacto del proveedor
     */
    private String telefono;

    @Column(name = "EmailProveedor",nullable = false)
    @Required
    /***
     * @param email
     * Correo Electronico del proveedor
     */
    private String email;
}
