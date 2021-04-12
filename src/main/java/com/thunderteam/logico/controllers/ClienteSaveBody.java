package com.thunderteam.logico.controllers;
import org.springframework.web.multipart.MultipartFile;
import com.thunderteam.logico.entities.Cliente;
import com.thunderteam.logico.entities.Ubicacion;
import lombok.Data;

@Data
public class ClienteSaveBody {
	Cliente cliente;
	Ubicacion ubicacion;
	String sector;
}
