<<<<<<< HEAD:servicios/servicios/src/main/java/com/servicio/servicios/service/ServicioService.java
package com.servicio.servicios.service;
=======
package com.local.locales.service;
>>>>>>> 20eaf0a2de7df1ebffeaecb80283babc2368ca3a:locales/locales/src/main/java/com/local/locales/service/ServicioService.java

import java.util.List;

import org.springframework.stereotype.Service;

<<<<<<< HEAD:servicios/servicios/src/main/java/com/servicio/servicios/service/ServicioService.java
import com.servicio.servicios.DTO.servicioDTO;
import com.servicio.servicios.model.servicio;
import com.servicio.servicios.repository.ServicioRepository;
=======
import com.local.locales.DTO.servicioDTO;
import com.local.locales.model.servicio;
import com.local.locales.repository.ServicioRepository;
>>>>>>> 20eaf0a2de7df1ebffeaecb80283babc2368ca3a:locales/locales/src/main/java/com/local/locales/service/ServicioService.java

@Service
public class ServicioService {

    private final ServicioRepository repository;

    public ServicioService(ServicioRepository repository) {

        this.repository = repository;
    }

    public List<servicio> listar() {
<<<<<<< HEAD:servicios/servicios/src/main/java/com/servicio/servicios/service/ServicioService.java
=======

        logger.info("Listando servicios");
>>>>>>> 20eaf0a2de7df1ebffeaecb80283babc2368ca3a:locales/locales/src/main/java/com/local/locales/service/ServicioService.java

        return repository.findAll();
    }

    public servicio buscarPorId(Integer id) {
<<<<<<< HEAD:servicios/servicios/src/main/java/com/servicio/servicios/service/ServicioService.java
=======

        logger.info("Buscando servicio");
>>>>>>> 20eaf0a2de7df1ebffeaecb80283babc2368ca3a:locales/locales/src/main/java/com/local/locales/service/ServicioService.java

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Servicio no encontrado"));
    }

    public servicio guardar(servicioDTO dto) {

<<<<<<< HEAD:servicios/servicios/src/main/java/com/servicio/servicios/service/ServicioService.java
=======
        logger.info("Guardando servicio");

>>>>>>> 20eaf0a2de7df1ebffeaecb80283babc2368ca3a:locales/locales/src/main/java/com/local/locales/service/ServicioService.java
        servicio servicio = new servicio();

        servicio.setNombre(dto.getNombre());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecio(dto.getPrecio());

        return repository.save(servicio);
    }

    public servicio actualizar(Integer id, servicioDTO dto) {

<<<<<<< HEAD:servicios/servicios/src/main/java/com/servicio/servicios/service/ServicioService.java
=======
        logger.info("Actualizando servicio");

>>>>>>> 20eaf0a2de7df1ebffeaecb80283babc2368ca3a:locales/locales/src/main/java/com/local/locales/service/ServicioService.java
        servicio servicio = buscarPorId(id);

        servicio.setNombre(dto.getNombre());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setPrecio(dto.getPrecio());

        return repository.save(servicio);
    }

    public void eliminar(Integer id) {

        repository.deleteById(id);
    }
}