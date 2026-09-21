package com.m4v3r1cx.adlerlistmonkintegrator.dto;

import lombok.Data;

import java.util.Map;

@Data
public class SubscriberDTO {
    private long codigoCliente;
    private String codContacto;
    private String nombreCliente;
    private String nombreContacto;
    private String email;
    private String tipoContacto;
    private String lineaNegocio;
    private String vendedor;
    private int categoria;
    private String keyAccount;
    private String clienteObjetivo;
    private String tipoCliente;
    private String estadoDesarrollo;
    private String recibeCorreos;
    private String eliminarBase;
    private String visitas36Meses;
    private String cotizacionesGanadas;
    private String montoAsegurado;
    private String telemarketing12meses;
}
