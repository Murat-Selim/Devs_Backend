package kodlamaio.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Devs.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

}
