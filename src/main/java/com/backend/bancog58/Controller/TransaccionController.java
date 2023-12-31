package com.backend.bancog58.Controller;

import com.backend.bancog58.Dao.ClienteDao;
import com.backend.bancog58.Dao.TransaccionDao;
import com.backend.bancog58.Models.Cliente;
import com.backend.bancog58.Models.Transaccion;
import com.backend.bancog58.Security.Hash;
import com.backend.bancog58.Service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionDao transaccionDao;
    @Autowired
    private ClienteDao dao;
    @Autowired
    private TransaccionService servicio;
    
    @PostMapping(value="/")
    @ResponseBody
    public ResponseEntity<Transaccion> agregar(@RequestBody Transaccion dato){   
        Transaccion obj = servicio.save(dato);
        return new ResponseEntity<>(obj, HttpStatus.OK);     
    }

    @PostMapping(value="/crear_transaccion") 
    public void crear_transaccion(@RequestParam ("idcta") String idcta,@RequestParam ("valor_transaccion") Double valor_transaccion,@RequestParam ("tipo") String tipo,@RequestHeader("clave")String clave,@RequestHeader("usuario")String usuario){ 
        Cliente objeto=new Cliente();
        objeto=dao.login(usuario, Hash.sha1(clave));
        if (objeto!=null) {
            servicio.cear_transaccion(idcta, valor_transaccion, tipo);
        }
          
    }

    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Transaccion> eliminar(@PathVariable Integer id){ 
        Transaccion objeto = servicio.findById(id); 
        if(objeto!=null) 
        servicio.delete(id);
        else 
            return new ResponseEntity<>(objeto, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(objeto, HttpStatus.OK); 
    }

    @PutMapping(value="/") 
    public ResponseEntity<Transaccion> editar(@RequestBody Transaccion dato){ 
        Transaccion objeto = servicio.findById(dato.getId_transaccion()); 
        if(objeto!=null) {
            objeto.setValor_transaccion(dato.getValor_transaccion());
            objeto.setFecha_transaccion(dato.getFecha_transaccion());
            objeto.setCuenta(dato.getCuenta());
           servicio.save(objeto);
        } 
        else 
            return new ResponseEntity<>(objeto, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(objeto, HttpStatus.OK); 
    }
    @GetMapping("/list") 
    public List<Transaccion> consultarTodo(){
        return servicio.findByAll(); 
    }
    @GetMapping("/list/{id}") 
    public Transaccion consultaPorId(@PathVariable Integer id){ 
        return servicio.findById(id); 
    }

    @GetMapping("/consulta_transaccion")
    @ResponseBody
    public ResponseEntity<List<Transaccion>> consulta_transaccion(@RequestParam ("idcta") String idcta,@RequestHeader ("usuario") String usuario,@RequestHeader ("clave") String clave) { 
        Cliente objeto=new Cliente();
        objeto=dao.login(usuario, Hash.sha1(clave));
        if (objeto!=null) {
            return new ResponseEntity<>(servicio.consulta_transaccion(idcta),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
 
    }
}
