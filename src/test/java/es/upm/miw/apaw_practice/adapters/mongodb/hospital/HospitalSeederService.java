package es.upm.miw.apaw_practice.adapters.mongodb.hospital;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.BedRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.IllnessRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.PatientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.RoomRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.*;
import es.upm.miw.apaw_practice.domain.models.hospital.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class HospitalSeederService {

    @Autowired
    private BedRepository bedRepository;
    @Autowired
    private IllnessRepository illnessRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoomRepository roomRepository;

    public void seedDatabase(){
        LogManager.getLogger(this.getClass()).warn("------- Hospital Initial Load -----------");

        IllnessEntity[] illnesses = {
                IllnessEntity.builder().phase(3).symptoms("Symptom A").endSymptoms().causes("Cause A").endCauses().contagious(true).build(),
                IllnessEntity.builder().phase(2).symptoms("Symptom B").symptoms("Symptom B2").endSymptoms().causes("Cause B").causes("Cause B2").endCauses().contagious(false).build(),
                IllnessEntity.builder().phase(4).symptoms("Symptom C").symptoms("Symptom C2").symptoms("Symptom C3").endSymptoms().causes("Cause C").causes("Cause C2").causes("Cause C3").endCauses().contagious(true).build(),
                IllnessEntity.builder().phase(1).symptoms("Symptom D").endSymptoms().causes("Cause D").causes("Cause D2").endCauses().contagious(false).build(),
                IllnessEntity.builder().phase(4).symptoms("Symptom D").endSymptoms().causes("Cause D").causes("Cause D2").endCauses().contagious(false).build()
        };
        this.illnessRepository.saveAll(Arrays.asList(illnesses));

        PatientEntity[] patients = {
                PatientEntity.builder().dni("11111111A").name("NameA").surname("SurnameA").pathologies("pathology A").pathologies("pathology A2").illnessEntities(illnesses[0]).build(),
                PatientEntity.builder().dni("22222222B").name("NameB").surname("SurnameB").pathologies("pathology B").pathologies("pathology B2").pathologies("pathology B3").illnessEntities(illnesses[0]).illnessEntities(illnesses[1]).build(),
                PatientEntity.builder().dni("33333333C").name("NameC").surname("SurnameC").pathologies("pathology C").pathologies("pathology C2").illnessEntities(illnesses[0]).illnessEntities(illnesses[1]).illnessEntities(illnesses[2]).build(),
                PatientEntity.builder().dni("44444444D").name("NameD").surname("SurnameD").pathologies("pathology D").pathologies("pathology D2").pathologies("pathology D3").illnessEntities(illnesses[0]).build(),
                PatientEntity.builder().dni("55555555E").name("NameE").surname("SurnameE").pathologies("pathology E").illnessEntities(illnesses[0]).illnessEntities(illnesses[1]).illnessEntities(illnesses[2]).illnessEntities(illnesses[3]).build(),
                PatientEntity.builder().dni("66666666F").name("NameF").surname("SurnameF").pathologies("pathology F").pathologies("pathology F2").illnessEntities(illnesses[0]).illnessEntities(illnesses[3]).build(),
        };
        this.patientRepository.saveAll(Arrays.asList(patients));

        RoomEntity[] rooms = {
                new RoomEntity("AreaA",1,List.of(patients[0],patients[1])),
                new RoomEntity("AreaB",2,List.of(patients[2],patients[3])),
                new RoomEntity("AreaC",3,List.of(patients[4])),
                new RoomEntity("AreaD",3,List.of(patients[5]))
        };
        this.roomRepository.saveAll(Arrays.asList(rooms));

        BedEntity[] beds = {
                new BedEntity(105,180,true, LocalDateTime.of(2020,10,2,10,0),rooms[0]),
                new BedEntity(125,190,true, LocalDateTime.of(2020,10,2,10,0),rooms[1]),
                new BedEntity(105,200,true, LocalDateTime.of(2020,10,3,15,0),rooms[2]),
                new BedEntity(105,190,false, null,rooms[0]),
        };
        this.bedRepository.saveAll(Arrays.asList(beds));
    }

    public void deleteAll() {
        this.bedRepository.deleteAll();
        this.roomRepository.deleteAll();
        this.patientRepository.deleteAll();
        this.illnessRepository.deleteAll();
    }
}
