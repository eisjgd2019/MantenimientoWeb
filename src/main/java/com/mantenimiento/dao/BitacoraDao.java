/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mantenimiento.dao;

import com.mantenimiento.dto.BitacoraDTO;
import com.mantenimiento.entity.BitacoraEventos;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hogar
 */
@Local
public interface BitacoraDao {

    public List<BitacoraDTO> obtenerEventos();
    
    public BitacoraDTO consultarBitacoraPorId(BitacoraEventos bitacoraEventos);
    
    public void adicionarBitacora(BitacoraDTO bitacoraDTO);

}
