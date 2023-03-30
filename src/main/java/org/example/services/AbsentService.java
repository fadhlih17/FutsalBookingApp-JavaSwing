package org.example.services;

import org.example.dtos.AbsentResponse;
import org.example.models.Absent;

import java.util.List;

public interface AbsentService {
    List<String> getIdNameEmployees();
    Absent createAbsent(Absent absent);
    List<AbsentResponse> findAllAbsent();
    List<AbsentResponse> findAllAbsentByDate(int date, int year);
    List<AbsentResponse> findAllAbsentDetails();
    List<AbsentResponse> findAllAbsentDetailByDate(int date, int year);
}
