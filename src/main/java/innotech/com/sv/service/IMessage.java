package innotech.com.sv.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import innotech.com.sv.modelos.Message;

public interface IMessage {
	
	public List<Message> findAll();

	public Page<Message> findAll(Pageable pageable);

	public Message findById(Long id);

	public Message save(Message message);

	public void delete(Long id);
}
