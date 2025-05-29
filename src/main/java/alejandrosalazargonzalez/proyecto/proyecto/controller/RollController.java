package alejandrosalazargonzalez.proyecto.proyecto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alejandrosalazargonzalez.proyecto.proyecto.model.Roll;
import alejandrosalazargonzalez.proyecto.proyecto.servicios.RollService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1")
public class RollController {
    private RollService rollService;

    @Autowired
    void setRollService(RollService rollService){
        this.rollService=rollService;
    }

    @GetMapping("/rolls/")
    public List<Roll> getAllRoles() {
        return rollService.getAllRoles();
    }

    @GetMapping("/roll/{id}")
    public ResponseEntity<Roll> getRoleById(@PathVariable(value = "id") int rollId) {
        Roll roll = rollService.getRoleById(rollId);
        return ResponseEntity.ok().body(roll);
    }

    @PostMapping("/add/roll/")
    public Roll createRole(@RequestBody Roll roll) {
        return rollService.createRole(roll);
    }

    @PutMapping("/update/roll/{id}")
    public ResponseEntity<Roll> updateRole(@PathVariable(value = "id") int rollId,
                                           @RequestBody Roll rollDetails) {
        final Roll updatedRole = rollService.updateRole(rollId, rollDetails);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/delete/roll/{id}")
    public Map<String, Boolean> deleteRole(@PathVariable(value = "id") int rollId) {
        rollService.deleteRole(rollId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
