package base.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import base.model.entity.Coche;

@Repository
public interface CocheJPAData extends JpaRepository<Coche, Integer>{

	public Coche findById(int id);
	public List<Coche> findAll();
	
}
