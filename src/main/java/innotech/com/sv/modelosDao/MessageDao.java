package innotech.com.sv.modelosDao;

import org.springframework.data.repository.PagingAndSortingRepository;

import innotech.com.sv.modelos.Message;

public interface MessageDao extends PagingAndSortingRepository <Message, Long>{

}
