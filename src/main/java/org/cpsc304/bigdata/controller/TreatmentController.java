package org.cpsc304.bigdata.controller;


import javafx.util.Pair;
import org.cpsc304.bigdata.db.dao.ClinicalTrialTreatmentDAO;
import org.cpsc304.bigdata.model.MedicalInfo.ClinicalTrial;
import org.cpsc304.bigdata.model.MedicalInfo.Treatment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@Controller
@RestController
public class TreatmentController {

    @Autowired
    private ClinicalTrialTreatmentDAO clinicalTrialTreatmentDAO;
    private Logger logger = LoggerFactory.getLogger(TreatmentController.class);

    @GetMapping("/treatment")
    public Object getTreatment (
            @RequestParam(value = "tname", required = false) final String tname,
            @RequestParam(value = "dname", required = false) final String dname,
            @RequestParam(value = "table", required = false) final String table){

        if(tname != null){
            return clinicalTrialTreatmentDAO.findTreatmentByName(tname);
        }
        if(dname != null){
            return clinicalTrialTreatmentDAO.findTreatmentByDisease(dname);
        }
        if(table != null){
            if(table.equalsIgnoreCase("Disease")){
                return clinicalTrialTreatmentDAO.crossReferenceDisease();
            }else if (table.equalsIgnoreCase("ClinicalTrial")){
                return clinicalTrialTreatmentDAO.crossReferenceClinicalTrial();
            }
        }

        return Collections.emptyList();
    }









}