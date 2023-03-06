package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.exception.ClientNotFoundException;
import com.example.demo.pojo.ClientDto;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.RemarkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
	private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
	@Autowired
	private ClientRepository repository;
    @Autowired
    private RemarkRepository remarkRepository;

	public List<ClientDto> findAllClients() {
		logger.info("ClientService : findAllClient()");
        return repository.findAll().stream().map(c -> maptoDto(c)).collect(Collectors.toList());
	}

    private ClientDto maptoDto(Client c) {
        return new ClientDto(c.getCId(), c.getName(), c.getPan(), c.getOnboardingDate(), c.getFollowUpDate(),
                remarkRepository.findAllBycId(c.getCId()));
    }

    public Client saveClient(Client newClient) {
		logger.info("ClientService : saveClient()");
		return repository.save(newClient);
	}


	public ClientDto findClientById(Long id) {
		logger.info("ClientService : findClientById()");
		return maptoDto(repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id)));
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
