package org.bahmni.module.hip.web.service;

import org.bahmni.module.hip.api.dao.CareContextRepository;
import org.bahmni.module.hip.model.PatientCareContext;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CareContextServiceTest {
    private CareContextRepository careContextRepository = mock(CareContextRepository.class);

    private CareContextService careContextServiceObject = new CareContextService(careContextRepository);

    @Test
    public void shouldFetchAllCareContextForPatient() {
        Integer patientId = 70;
        List<PatientCareContext> careContexts = new ArrayList<>();

        when(careContextRepository.getPatientCareContext(patientId))
                .thenReturn(careContexts);
        when(careContextRepository.isPatientIdExist(patientId))
                .thenReturn(true);

        careContextServiceObject.careContextForPatient(patientId);

        verify(careContextRepository, times(1))
                .getPatientCareContext(patientId);
    }
}
