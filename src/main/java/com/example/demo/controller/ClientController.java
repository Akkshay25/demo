package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.pojo.ClientDto;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
class ClientController {
	@Autowired
	private ClientService clientService;

	@GetMapping("/client")
	public ResponseEntity<List<ClientDto>> all() {
		return new ResponseEntity<>(clientService.findAllClients() , HttpStatus.OK) ;
	}

	@PostMapping("/client")
	public ResponseEntity<Client> newClient(@RequestBody Client newClient) {
		return new ResponseEntity<>(clientService.saveClient(newClient), HttpStatus.CREATED);
	}

	// Single item

	@GetMapping("/client/{id}")
	public ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
		return new ResponseEntity<>(clientService.findClientById(id), HttpStatus.OK);

	}

	@PutMapping("/client/{id}")
	public ResponseEntity<Client> replaceClient(@RequestBody Client newClient, @PathVariable Long id) {
		return new ResponseEntity<>(clientService.updateClient(newClient, id), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/client/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable Long id) {
		clientService.deleteClient(id);
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
	}
}