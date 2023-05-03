package id.co.mii.sima.serverapp.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.mii.sima.serverapp.models.Role;
import id.co.mii.sima.serverapp.repositories.RoleRepository;

@Service
@AllArgsConstructor
public class RoleService {

  private RoleRepository roleRepository;

  public List<Role> getAll() {
    return roleRepository.findAll();
  }

  public Role getById(Integer id) {
    return roleRepository
      .findById(id)
      .orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found!!")
      );
  }

  public Role create(Role role) {
    return roleRepository.save(role);
  }

  public Role update(Integer id, Role role) {
    getById(id); // method getById
    role.setId(id);
    return roleRepository.save(role);
  }

  public Role delete(Integer id) {
    Role role = getById(id);
    roleRepository.delete(role);
    return role;
  }
}