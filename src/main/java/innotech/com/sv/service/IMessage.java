package innotech.com.sv.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import innotech.com.sv.modelos.Mensaje;

public interface IMessage {
	
	public List<Mensaje> findAll();

	public Page<Mensaje> findAll(Pageable pageable);

	public Mensaje findById(Long id);

	public Mensaje save(Mensaje message);

	public void delete(Long id);
}
