package com.arcode.universitystudentlibrarysystem.manager.service;

import com.arcode.universitystudentlibrarysystem.manager.dto.ManagerDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ManagerService {

    ManagerDTO getManager(long managerId) throws Exception;

    List<ManagerDTO> getManagerList();

    void addManager(ManagerDTO managerDTO);

    void updateManager(long managerId, ManagerDTO managerDTO) throws Exception;

    void deleteManager(long managerId) throws Exception;
}
