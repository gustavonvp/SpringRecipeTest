package com.example.springrecipetest.services;

import com.example.springrecipetest.commands.UnitOfMeasureCommand;
import com.example.springrecipetest.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.example.springrecipetest.repository.UnitOfMeasureRepository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }


    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {
       return StreamSupport.stream(unitOfMeasureRepository.findAll()
       .spliterator(), false)
               .map(unitOfMeasureToUnitOfMeasureCommand::convert)
               .collect(Collectors.toSet());
    }
}
