package com.backend.portafolio.controller;

import com.backend.portafolio.mensaje.Mensaje;
import com.backend.portafolio.service.ImpPersonaService;
import com.backend.portafolio.service.EstudioService;
import com.backend.portafolio.service.ExperienciaService;
import com.backend.portafolio.service.PersonaService;
import com.backend.portafolio.service.ProyectoService;
import com.backend.portafolio.service.ServicioService;
import com.backend.portafolio.entity.Estudio;
import com.backend.portafolio.entity.Experiencia;
import com.backend.portafolio.entity.Persona;
import com.backend.portafolio.entity.Proyecto;
import com.backend.portafolio.entity.Servicio;
import com.backend.portafolio.service.ImpExperienciaService;
import com.backend.portafolio.service.ImpEstudioService;
import com.backend.portafolio.service.ImpProyectoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Controller {
    
    @Autowired
    private PersonaService persoServ; 
    
    @Autowired
    ImpPersonaService impPersonaService;
    
    @Autowired
    ImpProyectoService impProyectoService;
    
    @Autowired
    ImpEstudioService impEstudioService;
    
    @Autowired
    ImpExperienciaService impExperienciaService;
    
    @Autowired
    private EstudioService estuServ;
    
    @Autowired
    private ProyectoService proyServ;
        
    @Autowired
    private ServicioService servServ;
    
    @Autowired
    private ExperienciaService expeServ; 


    @PostMapping ("/autenticacion/loginADMIN")
    public Persona loginPersona (@RequestBody Persona pers) {
        return persoServ.loginPersona(pers.getCorreo(),pers.getContrasena());
    }
    

    //----------Persona end points
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona pers) {
             persoServ.crearPersona(pers);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/persona/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Persona dtopersona){
    if(!impPersonaService.existsById(id)){
    return new ResponseEntity(new Mensaje("no existe el id"),HttpStatus.NOT_FOUND);
    }
    if(impPersonaService.existsByNombre(dtopersona.getNombre())&& impPersonaService.getByNombre(dtopersona.getNombre()).get().getId()!=id){
    return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
    
    }
    if(StringUtils.isBlank(dtopersona.getNombre())){
    return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
    }
    
    Persona persona=impPersonaService.getOne(id).get();
    
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDomicilio(dtopersona.getDomicilio());
        persona.setTelefono(dtopersona.getTelefono());
        persona.setCorreo(dtopersona.getCorreo());
        persona.setSobre_mi(dtopersona.getSobre_mi());
        persona.setUrl_foto(dtopersona.getUrl_foto());
        persona.setContrasena(dtopersona.getContrasena());
        persona.setTitulo(dtopersona.getTitulo());
        persona.setEdad(dtopersona.getEdad());
        persona.setCumpleanos(dtopersona.getCumpleanos());
        persona.setNacionalidad(dtopersona.getNacionalidad());
        persona.setCv(dtopersona.getCv());
        
    impPersonaService.save(persona);
    return new ResponseEntity(new Mensaje("Persona actualizada"),HttpStatus.OK);
    }

    @GetMapping ("/ver/personas")
    @ResponseBody
    public List <Persona> verPersonas(){
        return persoServ.verPersonas();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/perosna/{id}")    
    public void eliminarPersona(@PathVariable Integer id){
        persoServ.eliminarPersona(id);
    }   
    
    @GetMapping ("/buscar/persona/{id}")
    public Persona buscarPersona(@PathVariable Integer id){
        return persoServ.buscarPersona(id);
    }
    
    //----------Estudio end points
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/estudio")
    public void agregarEstudio (@RequestBody Estudio estu) {
        estuServ.crearEstudio(estu);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/estudio/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Estudio dtoestudio){
    if(!impEstudioService.existsById(id)){
    return new ResponseEntity(new Mensaje("no existe el id"),HttpStatus.NOT_FOUND);
    }
    if(impEstudioService.existsByTitulo(dtoestudio.getTitulo())&& impEstudioService.getByTitulo(dtoestudio.getTitulo()).get().getId()!=id){
    return new ResponseEntity(new Mensaje("Ese titulo ya existe"),HttpStatus.BAD_REQUEST);
    
    }
    if(StringUtils.isBlank(dtoestudio.getTitulo())){
    return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
    }
    
    Estudio estudio=impEstudioService.getOne(id).get();
    
        estudio.setTitulo(dtoestudio.getTitulo());
        estudio.setPrograma(dtoestudio.getPrograma());
        estudio.setPersonaId(dtoestudio.getPersonaId());
        estudio.setFechas(dtoestudio.getFechas());
        estudio.setDescripcion(dtoestudio.getDescripcion());
        
    impEstudioService.save(estudio);
    return new ResponseEntity(new Mensaje("Estudio actualizada"),HttpStatus.OK);
    }
    
    @GetMapping ("/ver/estudios")
    @ResponseBody
    public List <Estudio> verEstudios(){
        return estuServ.verEstudios();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/estudio/{id}")    
    public void eliminarEstudio(@PathVariable Integer id){
        estuServ.eliminarEstudio(id);
    }   
    
    @GetMapping ("/buscar/estudio/{id}")
    public Estudio buscarEstudio(@PathVariable Integer id){
        return estuServ.buscarEstudio(id);
    }
    
    //-------Proyecto End points
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/proyecto")
    public void agregarProyecto (@RequestBody Proyecto proy) {
             proyServ.crearProyecto(proy);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/proyecto/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Proyecto dtoproyecto){
    if(!impProyectoService.existsById(id)){
    return new ResponseEntity(new Mensaje("no existe el id"),HttpStatus.NOT_FOUND);
    }
    if(impProyectoService.existsByTitulo(dtoproyecto.getTitulo())&& impProyectoService.getByTitulo(dtoproyecto.getTitulo()).get().getId()!=id){
    return new ResponseEntity(new Mensaje("Ese titulo ya existe"),HttpStatus.BAD_REQUEST);
    
    }
    if(StringUtils.isBlank(dtoproyecto.getTitulo())){
    return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
    }
    
    Proyecto proyecto=impProyectoService.getOne(id).get();
    
        proyecto.setTitulo(dtoproyecto.getTitulo());
        proyecto.setPrograma(dtoproyecto.getPrograma());
        proyecto.setFechas(dtoproyecto.getFechas());
        proyecto.setDescripcion(dtoproyecto.getDescripcion());
        proyecto.setUrl_imagen(dtoproyecto.getUrl_imagen());
        proyecto.setUrl(dtoproyecto.getUrl());
        proyecto.setPersonaId(dtoproyecto.getPersonaId());
        
    impProyectoService.save(proyecto);
    return new ResponseEntity(new Mensaje("Proyecto actualizado"),HttpStatus.OK);
    }
    
    @GetMapping ("/ver/proyectos")
    @ResponseBody
    public List <Proyecto> verProyectos(){
        return proyServ.verProyectos();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/proyecto/{id}")    
    public void eliminarProyecto(@PathVariable Integer id){
        proyServ.eliminarProyecto(id);
    }   
    
    @GetMapping ("/buscar/proyecto/{id}")
    public Proyecto buscarProyecto(@PathVariable Integer id){
        return proyServ.buscarProyecto(id);
    }    
    
    //-------Servicios End points
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/servicio")
    public void agregarServicio (@RequestBody Servicio serv) {
        servServ.crearServicio(serv);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping ("/ver/servicios")
    @ResponseBody
    public List <Servicio> verServicios(){
        return servServ.verServicios();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/servicio/{id}")    
    public void eliminarServicio(@PathVariable Integer id){
        servServ.eliminarServicio(id);
    }   
    
    @GetMapping ("/buscar/servicio/{id}")
    public Servicio buscarServicio(@PathVariable Integer id){
        return servServ.buscarServicio(id);
    }
    
    //-------Experiencia End points
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new/experiencia")
    public void agregarExperiencia (@RequestBody Experiencia expe) {
        expeServ.crearExperiencia(expe);
    }
    
    @GetMapping ("/ver/experiencias")
    @ResponseBody
    public List <Experiencia> verExperiencias(){
        return expeServ.verExperiencias();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/experiencias/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody Experiencia dtoexperiencia){
    if(!impExperienciaService.existsById(id)){
    return new ResponseEntity(new Mensaje("no existe el id"),HttpStatus.NOT_FOUND);
    }
    if(impExperienciaService.existsByTitulo(dtoexperiencia.getTitulo())&& impExperienciaService.getByTitulo(dtoexperiencia.getTitulo()).get().getId()!=id){
    return new ResponseEntity(new Mensaje("Ese titulo ya existe"),HttpStatus.BAD_REQUEST);
    
    }
    if(StringUtils.isBlank(dtoexperiencia.getTitulo())){
    return new ResponseEntity(new Mensaje("El campo no puede estar vacio"),HttpStatus.BAD_REQUEST);
    }
    
    Experiencia experiencia=impExperienciaService.getOne(id).get();
    
        experiencia.setTitulo(dtoexperiencia.getTitulo());
        experiencia.setEmpresa(dtoexperiencia.getEmpresa());
        experiencia.setPersonaId(dtoexperiencia.getPersonaId());
        experiencia.setFechas(dtoexperiencia.getFechas());
        experiencia.setDescripcion(dtoexperiencia.getDescripcion());
        
    impExperienciaService.save(experiencia);
    return new ResponseEntity(new Mensaje("Experiencia actualizada"),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/experiencia/{id}")    
    public void eliminarExperiencia(@PathVariable Integer id){
        expeServ.eliminarExperiencia(id);
    }   
    
    @GetMapping ("/buscar/experiencia/{id}")
    public Experiencia buscarExperiencia(@PathVariable Integer id){
        return expeServ.buscarExperiencia(id);
    }
}

