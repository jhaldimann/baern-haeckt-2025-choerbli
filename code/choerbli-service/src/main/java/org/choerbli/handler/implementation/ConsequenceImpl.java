package org.choerbli.handler.implementation;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ConsequenceDto;
import org.choerbli.controller.dto.request.ConsequenceCreationDto;
import org.choerbli.handler.port.ConsequencePort;
import org.choerbli.mapper.ConsequenceMapper;
import org.choerbli.model.Consequence;
import org.choerbli.repository.ConsequencesRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ConsequenceImpl implements ConsequencePort {
    private final ConsequencesRepository consequencesRepository;
    private final ConsequenceMapper consequenceMapper;

    @Override
    public ConsequenceDto create(ConsequenceCreationDto creationDto) {
        final Consequence consequence = this.consequenceMapper.toConsequence(creationDto);

        this.consequencesRepository.save(consequence);

        return this.consequenceMapper.toConsequenceDto(consequence);
    }
}
