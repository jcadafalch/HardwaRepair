/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.DAO.UsuariCrudDAO;
import cat.copernic.HardwaRepair.Model.Usuari;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jcadafalch
 */
@Service
public class UsuariServiceCRUD implements UsuariServiceInterface{
    
    @Autowired
    private UsuariCrudDAO usuari;

    @Override
    public List<Usuari> llistarUsuari() {
        return (List<Usuari>) usuari.findAll();
    }

    @Override
    @Transactional
    public void afegirUsuari(Usuari usuari) {
        this.usuari.save(usuari); 
    }

    @Override
    @Transactional
    public void eliminarUsuari(Usuari usuari) {
        this.usuari.delete(usuari); 
    }

    @Override
    @Transactional(readOnly=true)
    public Usuari cercarUsuari(Usuari usuari) {
        return this.usuari.findById(usuari.getIdUsuari()).orElse(null);
    }
    
}
