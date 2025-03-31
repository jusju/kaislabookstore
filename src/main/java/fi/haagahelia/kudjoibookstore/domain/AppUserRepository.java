package fi.haagahelia.kudjoibookstore.domain;

import org.springframework.data.repository.CrudRepository;


public interface AppUserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}