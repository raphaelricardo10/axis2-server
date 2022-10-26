package services.doctor;

import mock.MockData;
import stub.DoctorStub;

public class DoctorService {
    private DoctorStub[] doctors;

    public DoctorService() throws Exception {
        DoctorStub doctor = new DoctorStub(MockData.makeDoctor());
        this.doctors = new DoctorStub[] { doctor };
    }

    public DoctorStub[] getDoctors() {
        return this.doctors;
    }
}
