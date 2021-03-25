package com.UniAmerica.Prova41.controller;

import com.UniAmerica.Prova41.model.Marca;
import com.UniAmerica.Prova41.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Marca marca) throws Exception{
        try{
            Marca marcaCreated = marcaService.create(marca);
            return new ResponseEntity<>(marcaCreated, null, HttpStatus.CREATED);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Marca marca) throws Exception {
        try{
                marca.setId(id);
                Marca marcaUpdated= marcaService.update(marca);
                return new ResponseEntity<>(marcaUpdated, null, HttpStatus.OK);
            }
        catch(Exception ex) {
            throw new Exception(ex);
        }
    }

    @GetMapping
    public ResponseEntity<?> read() throws Exception{
        try{
            return new ResponseEntity<>(marcaService.findAll(), null, HttpStatus.OK);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        try{
                return new ResponseEntity<>(marcaService.findById(id), null, HttpStatus.OK);
            }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        try {
            Marca toDelete  = marcaService.findById(id);
            if(toDelete != null){
                marcaService.delete(toDelete);
                return new ResponseEntity<>(null, null, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null, null, HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }
}
