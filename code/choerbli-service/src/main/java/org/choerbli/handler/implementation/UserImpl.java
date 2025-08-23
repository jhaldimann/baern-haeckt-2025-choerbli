package org.choerbli.handler.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.UserDto;
import org.choerbli.controller.dto.request.UserCreationDto;
import org.choerbli.handler.port.UserPort;
import org.choerbli.mapper.UserMapper;
import org.choerbli.model.Choerbli;
import org.choerbli.model.User;
import org.choerbli.repository.ChoerbliRepository;
import org.choerbli.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
class UserImpl implements UserPort {
    private final UserRepository userRepository;
    private final ChoerbliRepository choerbliRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto getById(UUID id) {
        final Optional<User> user = this.userRepository.findById(id);

        if (user.isEmpty()) {
            throw new EntityNotFoundException("The user with ID %s was not found.".formatted(id));
        }

        return this.userMapper.toUserDto(user.get());
    }

    @Override
    public UserDto create(UserCreationDto creationDto) {
        final User user = this.userMapper.toUser(creationDto);

        final Choerbli choerbli = this.choerbliRepository.findById(user.getChoerbli().getId()).orElseThrow();
        user.setChoerbli(choerbli);
        this.userRepository.save(user);

        return this.userMapper.toUserDto(user);
    }
}
