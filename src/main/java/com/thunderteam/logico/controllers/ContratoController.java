package com.thunderteam.logico.controllers;

import java.util.Arrays;
import java.util.List;
import com.thunderteam.logico.entities.*;
import com.thunderteam.logico.repositorios.ContratoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContratoController {
	
	@Autowired
	ContratoRepo repo;
	
	
}
