package com.hotelSweetHome.hotelSweetHome.controller;

import com.hotelSweetHome.hotelSweetHome.models.entity.EstadoHabitacionEntity;
import com.hotelSweetHome.hotelSweetHome.models.outDTO.EstadoHabitacionDTO;
import com.hotelSweetHome.hotelSweetHome.services.IEstadoHabitacionService;
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
public class EstadoHabitacionRestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IEstadoHabitacionService estadoHabitacionService;

    @GetMapping("/estadosHabitacion")
    public List<EstadoHabitacionDTO> index() {
        return estadoHabitacionService.findAll()
                .stream()
                .map(outDTO -> modelMapper.map(outDTO, EstadoHabitacionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/estadoHabitacion/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();

        EstadoHabitacionEntity objeto = null;

        try {
            objeto = estadoHabitacionService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (objeto == null) {
            response.put("mensaje", "El estadoHabitacion con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        response.put("estadoHabitacionDTO", modelMapper.map(objeto, EstadoHabitacionDTO.class));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/estadoHabitacion")
    public ResponseEntity<?> create(@Valid @RequestBody EstadoHabitacionEntity objeto, BindingResult result) {

        EstadoHabitacionEntity objetoNew = null;
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
            objetoNew = estadoHabitacionService.save(objeto);
        } catch(DataAccessException e) {
            response.put("mensaje", "Error al insertar estadoHabitacion en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "EstadoHabitacion creado con éxito!");
        response.put("objeto", objetoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
