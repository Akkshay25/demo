package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
class ClientController {
	@Autowired
	private ClientService clientService;

	@GetMapping("/Client")
	public ResponseEntity<List<Client>> all() {
		return new ResponseEntity<>(clientService.findAllClients() , HttpStatus.OK) ;
	}

	@PostMapping("/Client")
	public ResponseEntity<Client> newClient(@RequestBody Client newClient) {
		return new ResponseEntity<>(clientService.saveClient(newClient), HttpStatus.CREATED);
	}

	// Single item

	@GetMapping("/Client/{id}")
	public ResponseEntity<Client> getClient(@PathVariable Long id) {
		return new ResponseEntity<>(clientService.findClientById(id), HttpStatus.OK);

	}

	@PutMapping("/Client/{id}")
	public ResponseEntity<Client> replaceClient(@RequestBody Client newClient, @PathVariable Long id) {
		return new ResponseEntity<>(clientService.updateClient(newClient, id), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/Client/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable Long id) {
		clientService.deleteClient(id);
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
	}
}