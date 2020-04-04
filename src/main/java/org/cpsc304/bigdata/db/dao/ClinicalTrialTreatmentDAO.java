package org.cpsc304.bigdata.db.dao;

import org.cpsc304.bigdata.model.MedicalInfo.ClinicalTrial;
import org.cpsc304.bigdata.model.MedicalInfo.Treatment;

import java.util.List;


public interface ClinicalTrialTreatmentDAO {
    void add(final ClinicalTrial trial, final Treatment treatment);
    void delete(final String ctname);

    List<ClinicalTrial> findClinicalTrialByName(final String name);
    Treatment findTreatmentByName(final String name);

    List<ClinicalTrial> findClinicalTrailByDisease(final String dname);
}
