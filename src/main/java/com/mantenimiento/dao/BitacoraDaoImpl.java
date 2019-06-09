package com.mantenimiento.dao;

import com.mantenimiento.dto.BitacoraDTO;
import com.mantenimiento.entity.BitacoraEventos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Stateless
public class BitacoraDaoImpl implements BitacoraDao {

    @PersistenceContext(unitName = "mantePU")
    EntityManager em;
    static Logger log = LogManager.getRootLogger();

    @Override
    public List<BitacoraDTO> obtenerEventos() {
        List<BitacoraDTO> bitacoraDTOs = null;
        List<BitacoraEventos> bitacoraEventos = em.createNamedQuery("BitacoraEventos.findAll").getResultList();
        if (bitacoraEventos != null) {
            bitacoraDTOs = new ArrayList<>();
            for (BitacoraEventos bitacoraEvento : bitacoraEventos) {
                log.debug(bitacoraEvento);
                bitacoraDTOs.add(transformarBitacoraToDto(bitacoraEvento));
            }
        }
        return bitacoraDTOs;
    }

    @Override
    public BitacoraDTO consultarBitacoraPorId(BitacoraEventos bitacoraEventos) {
        BitacoraEventos bitacoraEvento = em.find(BitacoraEventos.class, bitacoraEventos.getId());
        return transformarBitacoraToDto(bitacoraEvento);
    }

    @Override
    public void adicionarBitacora(BitacoraDTO bitacoraDTO) {
        em.persist(transformarDtoToBitacora(bitacoraDTO));
    }
    
    private BitacoraDTO transformarBitacoraToDto(BitacoraEventos bitacoraEvento){
        BitacoraDTO bitacoraDTO = new BitacoraDTO(bitacoraEvento.getId());
        bitacoraDTO.setFechaIni(bitacoraEvento.getFechaIni());
        bitacoraDTO.setFechaFin(bitacoraEvento.getFechaFin());
        bitacoraDTO.setTipo(bitacoraEvento.getTipo());
        bitacoraDTO.setOperador(bitacoraEvento.getOperador());
        bitacoraDTO.setTecnico(bitacoraEvento.getTecnico());
        bitacoraDTO.setObservaciones(bitacoraEvento.getObservaciones());
        System.out.println("************** " + bitacoraDTO.toString());
        return bitacoraDTO;
    }
    
    private BitacoraEventos transformarDtoToBitacora(BitacoraDTO bitacoraDTO){
        BitacoraEventos bitacoraEventos = null;
        if (bitacoraDTO.getId() != null) {
            bitacoraEventos = new BitacoraEventos(bitacoraDTO.getId());
        } else {
            bitacoraEventos = new BitacoraEventos();
        }
        bitacoraEventos.setFechaIni(bitacoraDTO.getFechaIni());
        bitacoraEventos.setFechaFin(bitacoraDTO.getFechaFin());
        bitacoraEventos.setTipo(bitacoraDTO.getTipo());
        bitacoraEventos.setOperador(bitacoraDTO.getOperador());
        bitacoraEventos.setTecnico(bitacoraDTO.getTecnico());
        bitacoraEventos.setObservaciones(bitacoraDTO.getObservaciones());
        return bitacoraEventos;
    }
}
