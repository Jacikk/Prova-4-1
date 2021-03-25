package com.UniAmerica.Prova41.controller;

import com.UniAmerica.Prova41.model.Carro;
import com.UniAmerica.Prova41.model.Marca;
import com.UniAmerica.Prova41.model.Modelo;
import com.UniAmerica.Prova41.service.CarroService;
import com.UniAmerica.Prova41.service.MarcaService;
import com.UniAmerica.Prova41.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;
    
    @Autowired
    private MarcaService marcaService;
    
    @Autowired
    private ModeloService modeloService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Carro carro) throws Exception{
        try{
            Carro carroCreated = carroService.create(carro);
            return new ResponseEntity<>(carroCreated, null, HttpStatus.CREATED);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Carro carro) throws Exception {
        try{
            Carro carroUpdated= carroService.update(carro);
            return new ResponseEntity<>(carroUpdated, null, HttpStatus.OK);
        }
        catch(Exception ex) {
            throw new Exception(ex);
        }
    }

    @GetMapping
    public ResponseEntity<?> read() throws Exception{
        try{
            return new ResponseEntity<>(carroService.findAll(), null, HttpStatus.OK);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) throws Exception{
        try{
            return new ResponseEntity<>(carroService.findById(id), null, HttpStatus.OK);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        try {
            Carro toDelete  = carroService.findById(id);
            if(toDelete != null){
                carroService.delete(toDelete);
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
    public ResponseEntity<?> carroPorMarca(@PathVariable String nomeMarca) throws Exception{
        try{

            Marca marca = marcaService.findByName(nomeMarca);

            List<Modelo> modelos = modeloService.findByMarca(marca);

            if(!modelos.isEmpty()){
                
                List<Carro> carros = new java.util.ArrayList<>(Collections.emptyList());

                for (Modelo modelo: modelos) {

                    carros.addAll(carroService.findByModelo(modelo));

                }
                if(!carros.isEmpty()) return new ResponseEntity<>(carros, null, HttpStatus.OK);
                else return new ResponseEntity<>(carros, null, HttpStatus.NO_CONTENT);
            }
            else return new ResponseEntity<>(modelos, null, HttpStatus.NO_CONTENT);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @GetMapping("/modelo/{nomeModelo}")
    public ResponseEntity<?> carroPorModelo(@PathVariable String nomeModelo) throws Exception{
        try{
            Modelo modelo = modeloService.findByName(nomeModelo);
            List<Carro> carros = carroService.findByModelo(modelo);
            if(!carros.isEmpty()){
                return new ResponseEntity<>(carros, null, HttpStatus.OK);
            }
            else return new ResponseEntity<>(carros, null, HttpStatus.NO_CONTENT);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<?> read(@PathVariable String placa) throws Exception{
        try{
            return new ResponseEntity<>(carroService.findByPlaca(placa), null, HttpStatus.OK);
        }
        catch (Exception ex){
            throw new Exception(ex);
        }
    }
}
