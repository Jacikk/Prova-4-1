package com.UniAmerica.Prova41.controller;

import com.UniAmerica.Prova41.model.Marca;
import com.UniAmerica.Prova41.model.Modelo;
import com.UniAmerica.Prova41.service.MarcaService;
import com.UniAmerica.Prova41.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @Autowired
    private MarcaService marcaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Modelo modelo) throws Exception{
        try{
            Modelo modeloCreated = modeloService.create(modelo);
            return new ResponseEntity<>(modeloCreated, null, HttpStatus.CREATED);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Modelo modelo) throws Exception {
        try{
            Modelo modeloUpdated= modeloService.update(modelo);
            return new ResponseEntity<>(modeloUpdated, null, HttpStatus.OK);
        }
        catch(Exception ex) {
            throw new Exception(ex);
        }
    }

    @GetMapping
    public ResponseEntity<?> read() throws Exception{
        try{
            return new ResponseEntity<>(modeloService.findAll(), null, HttpStatus.OK);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        try{
            return new ResponseEntity<>(modeloService.findById(id), null, HttpStatus.OK);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        try {
            Modelo toDelete  = modeloService.findById(id);
            if(toDelete != null){
                modeloService.delete(toDelete);
                return new ResponseEntity<>(null, null, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, null, HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @GetMapping("/marca/{nomeMarca}")
    public ResponseEntity<?> modelosPorMarca (@PathVariable String nomeMarca) throws Exception{
        try{
            Marca marca = marcaService.findByName(nomeMarca);
            List<Modelo> modelos= modeloService.findByMarca(marca);
            if(!modelos.isEmpty()){
                return new ResponseEntity<>(modelos, null, HttpStatus.OK);
            }
            else return new ResponseEntity<>(modelos, null, HttpStatus.NO_CONTENT);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

}
