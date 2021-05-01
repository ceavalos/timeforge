package innotech.com.sv.modelosDao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import innotech.com.sv.modelos.Mensaje;
import innotech.com.sv.modelos.SendMessage;

public interface SendMessageDao extends PagingAndSortingRepository <SendMessage, Long> {

	public SendMessage findByMessage(Mensaje message);
}
