/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mantenimiento.managedBean;

import com.mantenimiento.business.BitacoraEventosLocal;
import com.mantenimiento.dto.BitacoraDTO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Hogar
 */

@ManagedBean(name = "indexManagedBean")
@ViewScoped
public class IndexManagedBean {
    
    @EJB
    private BitacoraEventosLocal bitacoraEventosBean;
    private List<BitacoraDTO> listaBitacora;

  
    public IndexManagedBean() {
    }
    
    @PostConstruct
    public void inicializar() {
        
    }

    public List<BitacoraDTO> getListaBitacora() {
        return listaBitacora;
    }

    public void setListaBitacora(List<BitacoraDTO> listaBitacora) {
        this.listaBitacora = listaBitacora;
    }
    
    public void consultarBitacora() {
        listaBitacora = bitacoraEventosBean.obtenerListaEventos();
    }
}
