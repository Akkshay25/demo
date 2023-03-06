package com.example.demo.service;

import com.example.demo.entity.Remark;
import com.example.demo.exception.ClientNotFoundException;
import com.example.demo.repository.RemarkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemarkService {
	private static final Logger logger = LoggerFactory.getLogger(RemarkService.class);
	@Autowired
	private RemarkRepository repository;

	public List<Remark> findAllClients() {
		logger.info("ClientService : findAllClient()");
		return repository.findAll();
	}

	public Remark saveClient(Remark newRemark) {
		logger.info("ClientService : saveClient()");
		return repository.save(newRemark);
	}


	public Remark findClientById(Long id) {
		logger.info("ClientService : findClientById()");
		return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
	}

	public Remark updateClient(Remark newRemark, Long id) {
		logger.info("ClientService : updateClient()");
		return repository.findById(id).map(Remark -> {
			Remark.setRId(newRemark.getRId());
			
			return repository.save(Remark);
		}).orElseGet(() -> {
			newRemark.setRId(id);
			return repository.save(newRemark);
		});
	}

	public void deleteClient(Long id) {
		logger.info("ClientService : deleteClient()");
		repository.deleteById(id);

	}

}
