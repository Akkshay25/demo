package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.exception.ClientNotFoundException;
import com.example.demo.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
	@Autowired
	private ClientRepository repository;

	public List<Client> findAllClients() {
		logger.info("ClientService : findAllClient()");
		return repository.findAll();
	}

	public Client saveClient(Client newClient) {
		logger.info("ClientService : saveClient()");
		return repository.save(newClient);
	}


	public Client findClientById(Long id) {
		logger.info("ClientService : findClientById()");
		return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
	}

	public Client updateClient(Client newClient, Long id) {
		logger.info("ClientService : updateClient()");
		return repository.findById(id).map(Client -> {
			Client.setName(newClient.getName());
			Client.setPan(newClient.getPan());
			return repository.save(Client);
		}).orElseGet(() -> {
			newClient.setCId(id);
			return repository.save(newClient);
		});
	}

	public void deleteClient(Long id) {
		logger.info("ClientService : deleteClient()");
		repository.deleteById(id);

	}

}
