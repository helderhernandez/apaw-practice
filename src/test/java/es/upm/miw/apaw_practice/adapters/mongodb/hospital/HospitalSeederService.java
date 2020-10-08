package es.upm.miw.apaw_practice.adapters.mongodb.hospital;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.BedRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.IllnessRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.PatientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos.RoomRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.*;
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

        String [] pathologiesA = {"pathologieA","pathlologieA2"};
        String [] pathologiesB = {"pathologieB","pathologieB2","pathologieB3"};
        String [] pathologiesC = {"pathologieC","pathologieC2"};
        String [] pathologiesD = {"pathologieD","pathologieD2","pathologieD3"};
        String [] pathologiesE = {"pathologieE"};
        String [] pathologiesF = {"pathologieF","pathologieF2"};

        PatientEntity[] patients = {
                new PatientEntity("11111111A","NameA","SurnameA",pathologiesA, List.of(illnesses[0])),
                new PatientEntity("22222222B","NameB","SurnameB",pathologiesB, List.of(illnesses[0],illnesses[1])),
                new PatientEntity("33333333C","NameC","SurnameC",pathologiesC, List.of(illnesses[0],illnesses[1],illnesses[2])),
                new PatientEntity("44444444D","NameD","SurnameD",pathologiesD, List.of(illnesses[0])),
                new PatientEntity("55555555E","NameE","SurnameE",pathologiesE, List.of(illnesses[0],illnesses[1],illnesses[2],illnesses[3])),
                new PatientEntity("66666666F","NameF","SurnameF",pathologiesF, List.of(illnesses[0],illnesses[3])),
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
