/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mantenimiento.servicio.rest;

import com.mantenimiento.business.BitacoraEventosLocal;
import com.mantenimiento.dto.BitacoraDTO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/bitacora")
@Stateless
public class BitacoraRS implements Serializable {

    @EJB
    private BitacoraEventosLocal bitacoraEventosBean;

    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<BitacoraDTO> listarBitacoras() {
        return bitacoraEventosBean.obtenerListaEventos();
    }
    
    @GET
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public BitacoraDTO buscarBitacoraPrId(@PathParam("id") BigDecimal id){
        return bitacoraEventosBean.obtenerBitacoraPorId(id);
    }
    
    @POST
    @Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarEvento(BitacoraDTO bitacoraDTO){
        try {
            bitacoraEventosBean.agregarBitacora(bitacoraDTO);
            return Response.ok().entity(bitacoraDTO).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
