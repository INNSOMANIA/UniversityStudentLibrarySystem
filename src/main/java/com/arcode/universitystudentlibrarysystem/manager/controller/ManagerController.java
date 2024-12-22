package com.arcode.universitystudentlibrarysystem.manager.controller;

import com.arcode.universitystudentlibrarysystem.manager.dto.ManagerDTO;
import com.arcode.universitystudentlibrarysystem.manager.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/manager")
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping(value = "/{managerId}")
    public ManagerDTO getManager(@PathVariable("managerId") long managerId) throws Exception {
        return managerService.getManager(managerId);
    }

    @GetMapping(value = "")
    public List<ManagerDTO> getManagerList() {
        return managerService.getManagerList();
    }

    @PostMapping(value = "/add")
    public void addManager(@RequestBody ManagerDTO managerDTO) {
        managerService.addManager(managerDTO);
    }

    @PutMapping(value = "/{managerId}/update")
    public void updateManager(@PathVariable("managerId") long managerId, @RequestBody ManagerDTO managerDTO) throws Exception {
        managerService.updateManager(managerId, managerDTO);
    }

    @DeleteMapping(value = "/{managerId}/delete")
    public void deleteManager(@PathVariable("managerId") long managerId) throws Exception {
        managerService.deleteManager(managerId);
    }
}
