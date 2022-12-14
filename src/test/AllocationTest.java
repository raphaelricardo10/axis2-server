package test;

import org.junit.Test;

import mock.MockData;
import person.Person;
import hospital.Specialty;
import junit.framework.TestCase;
import schedule.doctor.DoctorSchedule;

public class AllocationTest extends TestCase {

    @Test
    public void testCanAllocateClient() throws Exception {
        Person client = MockData.makePerson();
        DoctorSchedule schedule = MockData.makeDoctorSchedule();
        schedule.allocateClient(client, Specialty.FAMILY_MEDICINE, schedule.getFirstAvailableTime());

        assertEquals(schedule.getAllocations(client).size(), 1);
    }
}
