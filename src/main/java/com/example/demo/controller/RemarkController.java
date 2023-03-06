package com.example.demo.controller;

import com.example.demo.entity.Remark;
import com.example.demo.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
class RemarkController {
	@Autowired
	private RemarkService remarkService;

	@GetMapping("/remark")
	public ResponseEntity<List<Remark>> all() {
		return new ResponseEntity<>(remarkService.findAllClients() , HttpStatus.OK) ;
	}

	@PostMapping("/remark")
	public ResponseEntity<Remark> newRemark(@RequestBody Remark newRemark) {
		return new ResponseEntity<>(remarkService.saveClient(newRemark), HttpStatus.CREATED);
	}

	// Single item

	@GetMapping("/remark/{id}")
	public ResponseEntity<Remark> getRemark(@PathVariable Long id) {
		return new ResponseEntity<>(remarkService.findClientById(id), HttpStatus.OK);

	}

	@PutMapping("/remark/{id}")
	public ResponseEntity<Remark> replaceRemark(@RequestBody Remark newRemark, @PathVariable Long id) {
		return new ResponseEntity<>(remarkService.updateClient(newRemark, id), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/remark/{id}")
	public ResponseEntity<String> deleteRemark(@PathVariable Long id) {
		remarkService.deleteClient(id);
		return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
	}
}