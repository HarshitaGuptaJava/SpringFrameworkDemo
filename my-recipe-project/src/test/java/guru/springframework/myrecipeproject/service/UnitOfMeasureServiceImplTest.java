package guru.springframework.myrecipeproject.service;

import guru.springframework.myrecipeproject.Commands.UnitOfMeasureCommand;
import guru.springframework.myrecipeproject.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.myrecipeproject.domain.UnitOfMeasure;
import guru.springframework.myrecipeproject.repositories.UnitOfMeaseureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UnitOfMeasureServiceImplTest {

    @Mock
    UnitOfMeaseureRepository unitOfMeaseureRepository;

    UnitOfMeasureServiceImpl unitOfMeasureServiceImpl;

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        unitOfMeasureServiceImpl=new UnitOfMeasureServiceImpl(unitOfMeaseureRepository,unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUomsTest() throws Exception {
        //given
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);

        when(unitOfMeaseureRepository.findAll()).thenReturn(unitOfMeasures);

        //when
        Set<UnitOfMeasureCommand> commands = unitOfMeasureServiceImpl.listAllUom();

        //then
        assertEquals(2, commands.size());
        verify(unitOfMeaseureRepository, times(1)).findAll();
    }

}