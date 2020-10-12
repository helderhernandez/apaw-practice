package es.upm.miw.apaw_practice.adapters.mongodb.transport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.DepartmentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.DepartmentEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transport.Department;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.DepartmentPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("departmentPersistence")
public class DepartmentPersistenceMongodb implements DepartmentPersistence {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentPersistenceMongodb(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Stream<Department> readAll() {
        return this.departmentRepository.findAll().stream()
                .map(DepartmentEntity::toDepartment);
    }

    @Override
    public Department update(Department department) {
        DepartmentEntity departmentEntity = this.departmentRepository
                .findById(department.getId())
                .orElseThrow(() -> new NotFoundException("Department id: " + department.getId()));
        departmentEntity.fromDepartment(department);
        return this.departmentRepository
                .save(departmentEntity)
                .toDepartment();
    }

    @Override
    public Department updateUbication(String name, String ubication) {
        DepartmentEntity departmentEntity = this.departmentRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Department name: " + name));
        departmentEntity.setUbication(ubication);
        return this.departmentRepository.save(departmentEntity).toDepartment();
    }
}
