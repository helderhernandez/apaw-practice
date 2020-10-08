package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.DegreeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.MachineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.EmployeeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.MachineEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import es.upm.miw.apaw_practice.domain.persistence_ports.factory.MachinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Stream<EmployeeEntity> employeesFromMachine (Machine machine) {
        Stream<EmployeeEntity> employeeStream = machine.getEmployeeEntities().stream();
        System.out.println("Employees from Machine: >>>> " + employeeStream.collect(Collectors.toList()));
        return employeeStream;
    }

    public List<String> employeeByDegree(String title) {
        return this.degreeRepository.findAll().stream()
                .filter(matchedTitle -> title.equals(matchedTitle.getTitle()))
                .map(employee -> employee.getEmployeeEntity().getDni())
                .collect(Collectors.toList());
        //System.out.println("Employees >>>: " + employeeList);

    }

    @Override
    public List<Machine> findMachineByEmployeeDegreeTitle(String title) {
        List<String> employeeList = this.degreeRepository.findAll().stream()
                .filter(matchedTitle -> title.equals(matchedTitle.getTitle()))
                .map(employee -> employee.getEmployeeEntity().getDni())
                .collect(Collectors.toList());
        System.out.println("Employees DNIs>>>: " + employeeList);
        //System.out.println("Before >>>> " + this.machineRepository.findAll());

        List<Machine> x = this.machineRepository.findAll().stream()
                .map(MachineEntity::toMachine)
                //.peek(c -> System.out.println("Machine >>>>> " + c.getSerialNumber()))
                .filter(machine -> machine.getEmployeeEntities().stream()
                        //.peek(c -> System.out.println("Employees in machine >>>>> " + c.getDni()))
                        .anyMatch(employeeEntity -> employeeList.contains(employeeEntity.getDni())))
                .peek(c -> System.out.println("Filtered machine  >>>>>  " + c.getSerialNumber()))
                .collect(Collectors.toList());
        System.out.println("Machines >>>: " + x);
        return x;
    }
}
/*
List<MachineEntity> x = this.machineRepository.findAll().stream()
                .peek(c -> System.out.println("Machine >>>>> " + c.getSerialNumber()))
                .filter(machine -> machine.getEmployeeEntities().stream()
                        .peek(c -> System.out.println("Employees in machine >>>>> " + c.getDni()))
                        .anyMatch(employeeEntity -> employeeList.contains(employeeEntity.getDni())))
                .peek(c -> System.out.println("Filtered machine  >>>>>  " + c.getSerialNumber()))
                .collect(Collectors.toList());
        System.out.println("Machines >>>: " + x);
        return null;
 */