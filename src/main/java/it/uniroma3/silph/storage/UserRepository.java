package it.uniroma3.silph.storage;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.silph.model.User;

/**
 * This interface is a JpaRepository for storage operations on Users.
 *
 * @see User
 */
public interface UserRepository extends JpaRepository<User, Long> {

}