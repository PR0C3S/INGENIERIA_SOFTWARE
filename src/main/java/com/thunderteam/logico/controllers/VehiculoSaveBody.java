package com.thunderteam.logico.controllers;

import org.springframework.web.multipart.MultipartFile;

import com.thunderteam.logico.entities.Vehiculo;
import com.thunderteam.logico.entities.Version_Vehiculo;

import lombok.Data;

@Data
public class VehiculoSaveBody{
	Vehiculo vehiculo;
	Version_Vehiculo version;
	//String modelo;
	//MultipartFile file;
}
