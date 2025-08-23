package org.choerbli.handler.implementation;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ConsequenceDto;
import org.choerbli.handler.port.ConsequencePort;
import org.choerbli.mapper.ConsequenceMapper;
import org.choerbli.model.Consequence;
import org.choerbli.repository.ConsequencesRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class ConsequenceImpl implements ConsequencePort {
    private final ConsequencesRepository consequencesRepository;
    private final ConsequenceMapper consequenceMapper;

    @Override
    public List<ConsequenceDto> create(List<ConsequenceDto> creationDtos) {
        final List<Consequence> consequences = creationDtos.stream().map(this.consequenceMapper::toConsequence).toList();

        this.consequencesRepository.saveAll(consequences);

        return consequences.stream().map(this.consequenceMapper::toConsequenceDto).toList();
    }
}
