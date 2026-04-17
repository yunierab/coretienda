package edu.tienda.core.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.tienda.core.domain.Producto;
import lombok.extern.slf4j.Slf4j;

@Service("API_EXTERNA") //Le damos un alias al servicio
@Slf4j  //Añadimos el logger proporcionado por lombok
public class ProductoServiceImplApiExterna implements IProductoService {
	
	public ProductoServiceImplApiExterna() {
		log.info("Llamdada a clase ProductoServiceImplApiExterna");
	}
	
	public List<Producto> getProductos() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Producto>> response = restTemplate.exchange("http://localhost:8080/tienda/api/v1/productos/fake-productos",
				                                                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Producto>>() {});
		List<Producto> productos = response.getBody();
		return productos;
	}

}
