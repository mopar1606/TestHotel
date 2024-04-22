package com.hotelSweetHome.hotelSweetHome.controller;

import com.hotelSweetHome.hotelSweetHome.models.entity.HabitacionEntity;
import com.hotelSweetHome.hotelSweetHome.models.outDTO.HabitacionDTO;
import com.hotelSweetHome.hotelSweetHome.services.IHabitacionService;
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
public class HabitacionRestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IHabitacionService habitacionService;

    @GetMapping("/habitaciones")
    public List<HabitacionDTO> index() {
        return habitacionService.findAll()
                .stream()
                .map(outDTO -> modelMapper.map(outDTO, HabitacionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/habitacion/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        HabitacionEntity objeto = null;

        try {
            objeto = habitacionService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (objeto == null) {
            response.put("mensaje", "La Habitacion con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        response.put("HabitacionDTO", modelMapper.map(objeto, HabitacionDTO.class));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/habitacionNumero/{numeroHabitacion}")
    public ResponseEntity<?> show(@PathVariable String numeroHabitacion) {

        Map<String, Object> response = new HashMap<>();

        HabitacionEntity objeto = null;

        try {
            objeto = habitacionService.findByNumeroHabitacion(numeroHabitacion);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (objeto == null) {
            response.put("mensaje", "La Habitacion con Numero: ".concat(numeroHabitacion.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        response.put("HabitacionDTO", modelMapper.map(objeto, HabitacionDTO.class));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/habitacion")
    public ResponseEntity<?> create(@Valid @RequestBody HabitacionEntity objeto, BindingResult result) {

        HabitacionEntity objetoNew = null;
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
            objetoNew = habitacionService.save(objeto);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al insertar habitacion en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Habitacion creado con éxito!");
        response.put("objeto", objetoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
