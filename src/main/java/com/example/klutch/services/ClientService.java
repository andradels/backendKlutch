package com.example.klutch.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.klutch.dto.ClientDTO;
import com.example.klutch.entities.Client;
import com.example.klutch.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll() {
		List<Client> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}
}
