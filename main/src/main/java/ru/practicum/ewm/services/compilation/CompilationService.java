package ru.practicum.ewm.services.compilation;

import ru.practicum.ewm.entity.dto.compilation.CompilationDto;
import ru.practicum.ewm.entity.dto.compilation.NewCompilationDto;
import ru.practicum.ewm.entity.dto.compilation.UpdateCompilationRequest;

import java.util.List;

public interface CompilationService {
    CompilationDto adminPostCompilation(NewCompilationDto newCompilationDto);

    void adminDeleteCompilation(Long compilationId);

    CompilationDto adminPatchCompilation(Long comp, UpdateCompilationRequest request);

    CompilationDto publicGetCompilation(Long compId);

    List<CompilationDto> publicGetCompilations(Boolean pinned, Integer from, Integer size);
}
