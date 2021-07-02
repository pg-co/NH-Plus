package Services;


import datastorage.DAOFactory;
import datastorage.PatientDAO;
import datastorage.TreatmentDAO;
import model.Patient;
import model.Treatment;

import java.sql.SQLException;

public class LockDataService {

    public int  getLockedPatientValue(long id) throws SQLException {
        PatientDAO pDao = DAOFactory.getDAOFactory().createPatientDAO();
        Patient test = pDao.read(id);
        return test.getLocked();
    }

    public int getLockedTreatmentValue(long id) throws SQLException {
        TreatmentDAO tDao = DAOFactory.getDAOFactory().createTreatmentDAO();
        Treatment tst = tDao.read(id);
        return tst.getLocked();
    }
}