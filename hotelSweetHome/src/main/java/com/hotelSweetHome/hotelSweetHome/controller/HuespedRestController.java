package com.hotelSweetHome.hotelSweetHome.controller;

import com.hotelSweetHome.hotelSweetHome.models.entity.HuespedEntity;
import com.hotelSweetHome.hotelSweetHome.models.outDTO.HuespedDTO;
import com.hotelSweetHome.hotelSweetHome.services.IHuespedService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class HuespedRestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IHuespedService huespedService;

    @GetMapping("/huespedes")
    public List<HuespedDTO> index() {
        return huespedService.findAll()
                .stream()
                .map(outDTO -> modelMapper.map(outDTO, HuespedDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/huesped/{dato}")
    public ResponseEntity<?> show(@PathVariable String dato) {

        Map<String, Object> response = new HashMap<>();

        HuespedEntity objeto = null;

        try {
            objeto = huespedService.findByDato(dato);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (objeto == null) {
            response.put("mensaje", "El Huesped con Dato: ".concat(dato.concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        response.put("HuespedDTO", modelMapper.map(objeto, HuespedDTO.class));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/huesped")
    public ResponseEntity<?> create(@Valid @RequestBody HuespedEntity objeto, BindingResult result) {

        HuespedEntity objetoNew = null;
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            objetoNew = huespedService.save(objeto);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al insertar huesped en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Huesped creado con éxito!");
        response.put("objeto", objetoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
