package br.com.gerenciar.vinho.server;


import br.com.gerenciar.vinho.dto.UsuarioDto;
import br.com.gerenciar.vinho.model.Usuario;
import br.com.gerenciar.vinho.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

        @Autowired
        private UsuarioRepository repository;

        @Autowired
        private ModelMapper modelMapper;

        public List<UsuarioDto> obterTodos() {
            return repository.findAll().stream()
                    .map(p -> modelMapper.map(p, UsuarioDto.class))
                    .collect(Collectors.toList());
        }

        public UsuarioDto obterPorId(Long id) {
            Usuario usuario = repository.findById(id)
                    .orElseThrow(EntityNotFoundException::new);
            return modelMapper.map(usuario, UsuarioDto.class);
        }

        @Transactional
        public UsuarioDto incluirUsuario(UsuarioDto usuarioDto) {
            Usuario usuario = repository.save(modelMapper.map(usuarioDto, Usuario.class));
            return modelMapper.map(usuario, UsuarioDto.class);
        }

}
