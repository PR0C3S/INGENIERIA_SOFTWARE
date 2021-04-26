package com.thunderteam.logico.controllers;

import com.thunderteam.logico.entities.Empleado;
import com.thunderteam.logico.entities.Ubicacion;
import lombok.Data;
@Data
public class EmpleadoSaveBody {
    Empleado empleado;
    Ubicacion ubicacion;
    String sector;
}


