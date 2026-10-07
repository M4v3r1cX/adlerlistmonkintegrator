package com.m4v3r1cx.adlerlistmonkintegrator.service;

import com.m4v3r1cx.adlerlistmonkintegrator.client.ListmonkClient;
import com.m4v3r1cx.adlerlistmonkintegrator.dto.SubscriberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SistasFileScanService {
    public static final String commaDelimiter = ",";
    public static final String fileRoute = "";

    @Autowired
    ListmonkClient listmonkClient;

    public void scanFiles() {
        // if file nuevo
        List<SubscriberDTO> clientes = getSubscribersFromFile();
        for (SubscriberDTO subscriberDTO : clientes) {
            listmonkClient.createSubscriber(subscriberDTO, null);
        }
    }

    public List<SubscriberDTO> getSubscribersFromFile() {
        List<SubscriberDTO> ret = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileRoute))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(commaDelimiter);
                ret.add(createSubscriberDto(values));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    private SubscriberDTO createSubscriberDto(String[] values) throws Exception {
        SubscriberDTO subscriberDTO = null;
        if (values != null && values.length > 0) {
            subscriberDTO = new SubscriberDTO();
            for (int i = 0; i < values.length; i++) {
                subscriberDTO.setCodigoCliente(Long.parseLong(values[0]));
                subscriberDTO.setCodContacto(values[1]);
                subscriberDTO.setNombreCliente(values[2]);
                subscriberDTO.setNombreContacto(values[3]);
                subscriberDTO.setEmail(values[4]);
                subscriberDTO.setTipoContacto(values[5]);
                subscriberDTO.setLineaNegocio(values[6]);
                subscriberDTO.setVendedor(values[7]);
                subscriberDTO.setCategoria(Integer.parseInt(values[8]));
                subscriberDTO.setKeyAccount(values[9]);
                subscriberDTO.setClienteObjetivo(values[10]);
                subscriberDTO.setTipoContacto(values[11]);
                subscriberDTO.setEstadoDesarrollo(values[12]);
                subscriberDTO.setRecibeCorreos(values[13]);
                subscriberDTO.setEliminarBase(values[14]);
                subscriberDTO.setVisitas36Meses(values[15]);
                subscriberDTO.setCotizacionesGanadas(values[16]);
                subscriberDTO.setMontoAsegurado(values[17]);
                subscriberDTO.setTelemarketing12meses(values[18]);
            }
        }
        return subscriberDTO;
    }
}