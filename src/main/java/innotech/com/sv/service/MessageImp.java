package innotech.com.sv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import innotech.com.sv.modelos.Message;
import innotech.com.sv.modelosDao.MessageDao;

@Service
public class MessageImp implements IMessage {

	@Autowired
	MessageDao messageDao;  
	
	@Override
	@Transactional(readOnly = true)
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return (List<Message>) messageDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Message> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return messageDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Message findById(Long id) {
		// TODO Auto-generated method stub
		return messageDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Message save(Message message) {
		// TODO Auto-generated method stub
		return messageDao.save(message);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		// TODO Auto-generated method stub
		messageDao.deleteById(id);
	}

}
