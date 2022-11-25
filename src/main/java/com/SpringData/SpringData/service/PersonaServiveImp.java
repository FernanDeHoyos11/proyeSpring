/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SpringData.SpringData.service;

import com.SpringData.SpringData.domin.persona;
import com.SpringData.SpringData.repo.IPersonaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fernan
 */
@Service // para inyectar IpersonaService dentro del controlador
public class PersonaServiveImp implements IpersonaService{

    @Autowired
    private IPersonaRepo personaRepo;
    
    @Override
    @Transactional(readOnly = true)// como solo se leera informacion importamos esta notacion
    // de spring y no de java
    public List<persona> ListarPersona() {
        return (List<persona>) personaRepo.findAll();
         }

    @Override
    @Transactional //aqui la dejanmos sin el readOnly porque se hara commit o rollBack
    public void guardar(persona person) {
        personaRepo.save(person);
         }

    @Override
    @Transactional //aqui la dejanmos sin el readOnly porque se hara commit o rollBack
    public void eliminar(persona peroson) {
        personaRepo.delete(peroson);
          }

    @Override
    @Transactional(readOnly = true)
    public persona BuscarPersona(persona person) {
        return personaRepo.findById(person.getId()).orElse(null);
          }
    
}
