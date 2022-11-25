/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringData.SpringData.domin;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 *
 * @author fernan
 */
@Entity
@Table(name ="usuarios")
@Data
public class usuarios implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    @OneToMany  //relacion uno a muchos con la entidad rol
    @JoinColumn(name="id_user")
   private List<rol> roles;
     
}
