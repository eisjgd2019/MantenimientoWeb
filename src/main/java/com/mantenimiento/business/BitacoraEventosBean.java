/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mantenimiento.business;

import com.mantenimiento.dao.BitacoraDao;
import com.mantenimiento.dto.BitacoraDTO;
import com.mantenimiento.entity.BitacoraEventos;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BitacoraEventosBean implements BitacoraEventosLocal {
    
    @EJB
    private BitacoraDao bitacoraDao;
    
    @Override
    public List<BitacoraDTO> obtenerListaEventos() {
        System.out.println("BitacoraEventosBean.obtenerListaEventos");
        return bitacoraDao.obtenerEventos();
    }

    @Override
    public BitacoraDTO obtenerBitacoraPorId(BigDecimal id) {
        return bitacoraDao.consultarBitacoraPorId(new BitacoraEventos(id));
    }

    @Override
    public void agregarBitacora(BitacoraDTO bitacoraDTO) {
        bitacoraDao.adicionarBitacora(bitacoraDTO);
    }
    
}
