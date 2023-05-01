package com.baezprog.demoConcesionario.negocio;

import com.baezprog.demoConcesionario.dto.ConcesionarioDto;
import com.baezprog.demoConcesionario.entity.Concesionario;
import com.baezprog.demoConcesionario.implementacion.ConcesionarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConcesionarioNegocio {

    @Autowired
    private ConcesionarioImpl concesionarioImpl;

    private List<ConcesionarioDto> listConcesionariosDto;


    public List<ConcesionarioDto> encontrarTodos(){
        listConcesionariosDto=new ArrayList<>();
        this.concesionarioImpl.encontrarTodos().forEach(concesionario->{
            ConcesionarioDto concesionarioDto = new ConcesionarioDto();
            concesionarioDto.setId(concesionario.getId());
            concesionarioDto.setNit(concesionario.getNit());
            concesionarioDto.setNombreConcesionario(concesionario.getNombreConcesionario());
            concesionarioDto.setDireccionConcesionario(concesionario.getDireccionConcesionario());
            concesionarioDto.setTelefonoConcesionario(concesionario.getTelefonoConcesionario());
            concesionarioDto.setCiudad(concesionario.getCiudad());
            //concesionarioDto.setFK_idCiudad(concesionario.getFK_idCiudad());
            this.listConcesionariosDto.add(concesionarioDto);
        });
        return this.listConcesionariosDto;
    }

    public String guardarConcesionario(ConcesionarioDto concesionarioDto){
        Concesionario concesionario=new Concesionario();
        try {
            if (concesionarioDto.getId() != 0) {
                concesionario.setId(concesionarioDto.getId());
                concesionario.setNit(concesionarioDto.getNit());
                concesionario.setNombreConcesionario(concesionarioDto.getNombreConcesionario());
                concesionario.setDireccionConcesionario(concesionarioDto.getNombreConcesionario());
                concesionario.setTelefonoConcesionario(concesionarioDto.getTelefonoConcesionario());
                concesionario.setCiudad(concesionarioDto.getCiudad());
                //concesionario.setFK_idCiudad(concesionarioDto.getFK_idCiudad());
                this.concesionarioImpl.actualizarConcesionario(concesionario);
            } else {
                //concesionario.setId(concesionarioDto.getId());
                concesionario.setNit(concesionarioDto.getNit());
                concesionario.setNombreConcesionario(concesionarioDto.getNombreConcesionario());
                concesionario.setDireccionConcesionario(concesionarioDto.getNombreConcesionario());
                concesionario.setTelefonoConcesionario(concesionarioDto.getTelefonoConcesionario());
                concesionario.setCiudad(concesionarioDto.getCiudad());
                //concesionario.setFK_idCiudad(concesionarioDto.getFK_idCiudad());
                this.concesionarioImpl.crearConcesionario(concesionario);
            }
            return "Se guardaron correctamente";
        }catch (Exception e){
            return "Fallo algo";
        }
    }
}
