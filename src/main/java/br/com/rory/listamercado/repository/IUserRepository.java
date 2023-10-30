package br.com.rory.listamercado.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rory.listamercado.model.UserModel;
import java.util.List;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    List<UserModel> findByid(UUID id);
}
