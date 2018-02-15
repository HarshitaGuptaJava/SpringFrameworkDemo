package guru.springframework.myrecipeproject.service;

import guru.springframework.myrecipeproject.Commands.UnitOfMeasureCommand;
import guru.springframework.myrecipeproject.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {

    public Set<UnitOfMeasureCommand> listAllUom();
}
