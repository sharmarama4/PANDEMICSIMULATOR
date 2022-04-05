package sorter;

import Pandemic.Patient;

import java.util.Comparator;

public class PatientTemperatureSorter implements Comparator<Patient> {




    @Override
    public int compare(Patient o1, Patient o2) {
        return-( o1.getTemperature()-o2.getTemperature());
    }
}
