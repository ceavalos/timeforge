package innotech.com.sv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import innotech.com.sv.modelos.SendMessage;
import innotech.com.sv.modelosDao.SendMessageDao;

@Service
public class SendMessageImp implements ISendMessage {

	@Autowired
	SendMessageDao sendMessageDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<SendMessage> findAll() {
		// TODO Auto-generated method stub
		return (List<SendMessage>) sendMessageDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<SendMessage> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return sendMessageDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public SendMessage findById(Long id) {
		// TODO Auto-generated method stub
		return sendMessageDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public SendMessage save(SendMessage sendMessage) {
		// TODO Auto-generated method stub
		return sendMessageDao.save(sendMessage);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		// TODO Auto-generated method stub
		sendMessageDao.deleteById(id);
	}

}
