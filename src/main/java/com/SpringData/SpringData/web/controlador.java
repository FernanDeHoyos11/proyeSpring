/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringData.SpringData.web;


import com.SpringData.SpringData.domin.persona;
import com.SpringData.SpringData.service.IpersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author fernan
 */

@Controller
public class controlador {
    
    //para inyectar cualquier dependencia manejada por el contenedor
    @Autowired
    private IpersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model){
     var personas = personaService.ListarPersona();
        var mensaje = "Hola mundo con model";
        model.addAttribute("personas",personas);
        var saldoTotal =0D;
        for(var p : personas){
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal",saldoTotal);
        model.addAttribute("totalClientes",personas.size());
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(persona person){
        return "form";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Validated persona person, Errors errores){
        if(errores.hasErrors()){
            return "form";
        }
        personaService.guardar(person);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(persona person,  Model model){
        person = personaService.BuscarPersona(person);
        model.addAttribute("persona", person);
        return "form";
    }
    
      @GetMapping("/eliminar")
    public String eeliminar(persona person){
         personaService.eliminar(person);
        return "redirect:/";
    }
}



