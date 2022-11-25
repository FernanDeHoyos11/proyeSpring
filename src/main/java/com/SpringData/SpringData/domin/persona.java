/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringData.SpringData.domin;

import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author fernan
 */
@Data //nos crea los metodos basicos de una clase como los SET; GET, etc
@Entity // esta notacion crea la tabla en la base de datos
@Table(name = "persona")
public class persona implements Serializable{
    
    public persona(){}
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
     private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String celular;
    @NotNull
    private Double saldo;
}
