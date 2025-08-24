package org.choerbli.handler.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ConsequenceDto;
import org.choerbli.controller.dto.request.ConsequenceCreationDto;
import org.choerbli.handler.port.ConsequencePort;
import org.choerbli.mapper.ConsequenceMapper;
import org.choerbli.model.Choerbli;
import org.choerbli.model.Consequence;
import org.choerbli.repository.ChoerbliRepository;
import org.choerbli.repository.ConsequencesRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
class ConsequenceImpl implements ConsequencePort {
    private final ConsequencesRepository consequencesRepository;
    private final ChoerbliRepository choerbliRepository;
    private final ConsequenceMapper consequenceMapper;

    @Override
    public List<ConsequenceDto> create(List<ConsequenceCreationDto> creationDtos) {
        List<Consequence> list = new ArrayList<>();

        for (ConsequenceCreationDto dto : creationDtos) {
            final Choerbli choerbli = this.choerbliRepository.findById(dto.choerbliId()).orElseThrow(() -> new EntityNotFoundException("The choerbli with ID %s was not found.".formatted(dto.choerbliId())));

            final Consequence consequence = this.consequenceMapper.toConsequence(dto);

            consequence.setChoerbli(choerbli);

            this.consequencesRepository.save(consequence);

            list.add(consequence);
        }

        return list.stream().map(this.consequenceMapper::toConsequenceDto).toList();
    }
}
