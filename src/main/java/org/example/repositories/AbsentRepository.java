package org.example.repositories;

import org.example.dtos.AbsentResponse;
import org.example.models.Absent;

import java.util.List;

public interface AbsentRepository {
    Absent createAbsent(Absent absent);
    List<AbsentResponse> findAllAbsent();
    List<AbsentResponse> findAbsentByDate(int month, int year);
    List<AbsentResponse> findAllAbsentDetail();
    List<AbsentResponse> findAbsentDetailByDate(int date, int year);
}
