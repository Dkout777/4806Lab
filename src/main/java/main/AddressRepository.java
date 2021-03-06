package main;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressbook", path = "addressbook")
public interface AddressRepository extends CrudRepository<AddressBook, Long> {
    AddressBook findById(long id);
}