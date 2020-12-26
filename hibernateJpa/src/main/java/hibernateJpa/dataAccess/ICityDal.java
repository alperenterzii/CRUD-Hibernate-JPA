package hibernateJpa.dataAccess;
import java.util.List;



import hibernateJpa.entities.*;

public interface ICityDal {
	
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);

}
