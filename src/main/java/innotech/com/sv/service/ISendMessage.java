package innotech.com.sv.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import innotech.com.sv.modelos.SendMessage;

public interface ISendMessage {

	public List<SendMessage> findAll();

	public Page<SendMessage> findAll(Pageable pageable);

	public SendMessage findById(Long id);

	public SendMessage save(SendMessage sendMessage);

	public void delete(Long id);
}
