package com.arcode.universitystudentlibrarysystem.manager.service;

import com.arcode.universitystudentlibrarysystem.manager.dto.ManagerDTO;
import com.arcode.universitystudentlibrarysystem.manager.persistence.db.ManagerRepository;
import com.arcode.universitystudentlibrarysystem.manager.persistence.entity.Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagerServiceBean implements ManagerService {

    private final ManagerRepository<Manager> managerRepository;

    @Override
    public ManagerDTO getManager(long managerId) throws Exception {
        Optional<Manager> optionalManager = managerRepository.findById(managerId);
        if (optionalManager.isPresent()) {
            Manager manager = optionalManager.get();
            return new ManagerDTO(
                    manager.getId(),
                    manager.getName(),
                    manager.getSurname(),
                    manager.getBirthDay());

        } else {
            throw new Exception("Manager is not found in the system");
        }
    }

    @Override
    public List<ManagerDTO> getManagerList() {
        return managerRepository.findAll().stream().map(
                        manager -> new ManagerDTO(
                                manager.getId(),
                                manager.getName(),
                                manager.getSurname(),
                                manager.getBirthDay()))
                .collect(Collectors.toList());
    }

    @Override
    public void addManager(ManagerDTO managerDTO) {
        Manager manager = Manager.builder()
                .id(managerDTO.getId())
                .name(managerDTO.getName())
                .surname(managerDTO.getSurname())
                .birthDay(managerDTO.getBirthDay())
                .build();

        managerRepository.save(manager);
    }

    @Override
    public void updateManager(long managerId, ManagerDTO managerDTO) throws Exception {
        final Optional<Manager> resultManager = managerRepository.findById(managerId);
        if (resultManager.isPresent()) {
            resultManager.get().setName(managerDTO.getName());
            resultManager.get().setSurname(managerDTO.getSurname());
            resultManager.get().setBirthDay(managerDTO.getBirthDay());

            managerRepository.save(resultManager.get());
        } else {
            throw new Exception("Manager with id " + managerId + " does not update.");
        }
    }

    @Override
    public void deleteManager(long managerId) throws Exception {
        final Optional<Manager> possibleManager = managerRepository.findById(managerId);
        if (possibleManager.isPresent()) {
            final Manager manager = possibleManager.get();
            managerRepository.delete(possibleManager.get());
        } else {
            throw new Exception("Manager with id " + managerId + " does not exist.");
        }
    }
}
