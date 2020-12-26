package hibernateJpa.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hibernateJpa.entities.City;

@Repository
public class CityDal implements ICityDal {

	private EntityManager entityManager;
	
	@Autowired
	public CityDal(EntityManager entityManager) {
		this.entityManager= entityManager;
	}
	
	@Transactional
	public List<City> getAll() {
	Session session =	entityManager.unwrap(Session.class);
	List<City> cities = session.createQuery("from City", City.class).getResultList();
		return cities;
	}

	@Override
	@Transactional
	public void add(City city) {
		Session session =	entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		Session session =	entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		Session session =	entityManager.unwrap(Session.class);
		City cityToDelete = session.get(City.class, city.getId());
		session.delete(cityToDelete);
	}
	@Transactional
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class, id);
		return city;
		
	}

}
