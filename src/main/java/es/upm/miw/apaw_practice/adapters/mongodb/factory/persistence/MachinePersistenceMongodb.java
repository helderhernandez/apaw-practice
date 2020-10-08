package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.DegreeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.MachineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.MachineEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.factory.Employee;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import es.upm.miw.apaw_practice.domain.persistence_ports.factory.MachinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("machinePersistence")
public class MachinePersistenceMongodb implements MachinePersistence {
    private MachineRepository machineRepository;

    private DegreeRepository degreeRepository;


    @Autowired
    public MachinePersistenceMongodb(MachineRepository machineRepository, DegreeRepository degreeRepository) {
        this.machineRepository = machineRepository;
        this.degreeRepository = degreeRepository;
    }

    @Override
    public Machine updateStatus(String id, Boolean active) {
        MachineEntity machineEntity = this.machineRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Machine id: " + id));
        machineEntity.setActive(active);
        return this.machineRepository
                .save(machineEntity)
                .toMachine();
    }

    @Override
    public List<Machine> findMachineByEmployeeDegreeTitle(String title) {
        List<Employee> employeeList = this.degreeRepository.findAll().stream()
                .filter(matchedTitle -> title.equals(matchedTitle.getTitle()))
                .map(employee -> employee.getEmployeeEntity().toEmployee())
                .collect(Collectors.toList());
        System.out.println("Employees >>>: " + employeeList);
        System.out.println("Before >>>> " + this.machineRepository.findAll());
        List<Machine> x = this.machineRepository.findAll().stream()
                .filter(machines -> !employeeList.contains(machines.getEmployeeEntities()))
                .map(MachineEntity::toMachine)
                .collect(Collectors.toList());
        System.out.println("Machines >>>: " + x);

        return x;
    }
}
