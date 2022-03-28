/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.copernic.HardwaRepair.serveis;

import cat.copernic.HardwaRepair.DAO.CategoriaDAO;
import cat.copernic.HardwaRepair.Model.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jcadafalch
 */
public class CategoriaService implements CategoriaServiceInterface{
    
    @Autowired
    private CategoriaDAO categoria;

    @Override
    @Transactional (readOnly = true)
    public List<Categoria> llistarCategories() {
        return (List<Categoria>) categoria.findAll();
    }

    @Override
    @Transactional
    public void afegirCategoria(Categoria categoria) {
        this.categoria.save(categoria);
    }

    @Override
    @Transactional
    public void eliminarCategoria(Categoria categoria) {
        this.categoria.delete(categoria);
    }

    @Override
    @Transactional (readOnly = true)
    public Categoria cercarCategoria(Categoria categoria) {
        //Si el producte no existeix retornarà null ( orElse(null) )
        return this.categoria.findById(categoria.getIdCategoria()).orElse(null);
    }
    
}
