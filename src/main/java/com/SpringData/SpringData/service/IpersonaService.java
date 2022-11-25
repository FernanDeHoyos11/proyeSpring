/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SpringData.SpringData.service;

import com.SpringData.SpringData.domin.persona;
import java.util.List;

/**
 *
 * @author fernan
 */
public interface IpersonaService {
    
    public List<persona> ListarPersona();
    
    public void guardar(persona person);
    public void eliminar(persona peroson);
    public persona BuscarPersona(persona person);
}
