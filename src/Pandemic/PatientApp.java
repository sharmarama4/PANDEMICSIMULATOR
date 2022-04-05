package Pandemic;


import sorter.PatientInsuranceSorter;
import sorter.patientAgeSorter;

import java.util.*;
import java.util.stream.Collectors;

public class PatientApp {


    public static void main(String[] args) {



        List<Patient> patientList = Patient.getAllPatients();
        patientList.forEach(System.out::println);
        System.out.println("----");

   //Eerste vraag
        Set<Patient> patientSet = new LinkedHashSet<>();
        patientSet.addAll(patientList);
        for (Patient patient : patientSet) {
            System.out.println(patient);
        }
        System.out.println("----");
        //2 de Vraag
        patientList.sort(new patientAgeSorter());
        for (Patient p : patientList) {
            System.out.println(p);
        }
        System.out.println("----");

        patientList.sort(Comparator.comparingInt(Patient::getTemperature));
        for (Patient p : patientList) {
            System.out.println(p);
        }
        System.out.println("----");
        //Bonus
        Queue<Patient> patientQueue = new PriorityQueue<>(new PatientInsuranceSorter());
        patientQueue.addAll(patientSet);
        patientQueue.forEach(System.out::println);
        System.out.println("----");
//category1
        List<Patient>highRiskPatient=patientList.stream().filter(patient->patient.getAge()>=65&&patient.getTemperature()>=38).
       filter(patient ->  patient.isUnKnownVirus()||patient.getTemperature()>=40)
                .sorted(Comparator.comparingInt(Patient::getAge)).sorted(Comparator.comparingInt(Patient::getTemperature))
                .collect(Collectors.toList());
        for(Patient p:highRiskPatient){
            System.out.println(p);
        }
 System.out.println("---");
        //category 2
        List<Patient>highFever=patientList.stream().filter(patient -> patient.getTemperature()>=38&& patient
                .isUnKnownVirus()).sorted(Comparator.comparingInt(Patient::getTemperature)).collect(Collectors.toList());
        for(Patient p:highFever){
            System.out.println(p);
        }
        System.out.println("---");
        //category 3
        List<Patient>noFeverPatient = patientList.stream().filter(patient -> patient.isUnKnownVirus()).filter(patient ->
                !(patient.getTemperature() >=38)).sorted(Comparator.comparingInt(Patient::getTemperature)).collect(Collectors.toList());
        for(Patient p:noFeverPatient){
            System.out.println(p);
        }
        System.out.println("---");
        //category 4
        List<Patient>noVirus=patientList.stream().filter(patient -> !patient.isUnKnownVirus()).filter(patient ->
                patient.getTemperature()>38).sorted(Comparator.comparingInt(Patient::getTemperature)).collect(Collectors.toList());
        for(Patient p:noVirus){
            System.out.println(p);
        }
        System.out.println("---");
        //map
        Map<List<Patient>, Patient> patientMap=new TreeMap<>();
        try {
            patientMap.put(highRiskPatient, new Patient("582201321",
                    "Alexander Hamilton", 65, 38, false, false));
            patientMap.put(highFever, new Patient("110201321", "Donald Putin", 90,
                    39, false, true));
            patientMap.put(noFeverPatient, new Patient("030209741",
                    "Willy Wonka", 70, 40, true, true));
            patientMap.put(noVirus, new Patient("030801321",
                    "Gringoire Lune", 80, 36, true, true));


            for (Map.Entry<List<Patient>, Patient> category : patientMap.entrySet()) {
                System.out.println(category.getKey() + " " + category.getValue());

                System.out.println("------");
            }
        }catch (ClassCastException exception){
            System.out.println("It must  work");
        }
    }
        public static List<Patient> getAllPatients () {
            List<Patient> allPatients = new ArrayList<>();
            Patient princeCharming = new Patient("368201321", "Prince Charming", 95, 37, true, true);
            Patient crazyFrog = new Patient("687201321", "Crazy Frog", 5, 39, false, false);
            Patient donaldPutin = new Patient("110201321", "Donald Putin", 90, 39, false, true);
            allPatients.add(new Patient("030201321", "Lucky Luke", 69, 38, true, false));
            allPatients.add(new Patient("030201322", "Stromae Papaoutai", 35, 40, false, true));
            allPatients.add(new Patient("030801321", "Gringoire Lune", 80, 36, true, true));
            allPatients.add(crazyFrog);
            allPatients.add(new Patient("030244321", "Sanic the HedgeHog", 16, 37, true, true));
            allPatients.add(donaldPutin);
            allPatients.add(donaldPutin);
            allPatients.add(new Patient("088201321", "Bilbo Baggins", 23, 39, true, false));
            allPatients.add(new Patient("035501321", "Lucio Correa Dos Santos", 40, 38, false, true));
            allPatients.add(new Patient("030206621", "Doctor Who", 33, 35, true, true));
            allPatients.add(new Patient("030245321", "Luke Cage", 46, 41, true, false));
            allPatients.add(new Patient("030298321", "Naruto Uzumaki", 13, 38, false, false));
            allPatients.add(new Patient("125201321", "Billy Batson", 15, 40, true, false));
            allPatients.add(new Patient("987201321", "Joseph Joestar", 75, 36, true, false));
            allPatients.add(new Patient("645201321", "Jon Snow", 33, 35, false, false));
            allPatients.add(princeCharming);
            allPatients.add(new Patient("582201321", "Alexander Hamilton", 65, 38, false, false));
            allPatients.add(crazyFrog);
            allPatients.add(new Patient("030201231", "Zelda of Hyrule", 17, 38, false, true));
            allPatients.add(new Patient("830208651", "Mother Theresa", 98, 39, true, false));
            allPatients.add(new Patient("030209741", "Willy Wonka", 70, 40, true, true));
            allPatients.add(new Patient("030205411", "Scrooge McDuck", 73, 38, true, false));
            allPatients.add(princeCharming);
            allPatients.add(new Patient("030209861", "Sonia Magnlia", 35, 39, false, false));
            allPatients.add(new Patient("030278921", "Peter Parker", 21, 0, true, false));
            allPatients.add(new Patient("030269821", "Bruce Wayne", 46, 35, false, true));
            allPatients.add(new Patient("030296321", "Mario Mario", 50, 37, false, false));
            allPatients.add(new Patient("035051321", "Harry Potter", 18, 39, true, true));
            allPatients.add(princeCharming);
            allPatients.add(new Patient("036781321", "Mary Poppins", 38, 38, true, false));
            allPatients.add(new Patient("033691321", "Alexander the Great", 51, 37, false, true));
            allPatients.add(crazyFrog);
            allPatients.add(new Patient("030201000", "Huey Freeman", 12, 40, false, false));
            allPatients.add(new Patient("000201321", "Miku Hatsune", 16, 36, true, true));
            allPatients.add(new Patient("111201321", "Drake Josh", 33, 38, true, false));
            allPatients.add(new Patient("222201321", "April O'Neil", 29, 37, false, false));
            return allPatients;


        }

    }




