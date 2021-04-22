package innotech.com.sv.modelosDao;

import org.springframework.data.repository.PagingAndSortingRepository;

import innotech.com.sv.modelos.SendMessage;

public interface SendMessageDao extends PagingAndSortingRepository <SendMessage, Long> {

}
