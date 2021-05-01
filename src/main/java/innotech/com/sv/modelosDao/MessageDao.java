package innotech.com.sv.modelosDao;

import org.springframework.data.repository.PagingAndSortingRepository;

import innotech.com.sv.modelos.Mensaje;

public interface MessageDao extends PagingAndSortingRepository <Mensaje, Long>{

}
