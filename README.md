# Simulador de Procesamiento de Compras en Supermercado

Este proyecto es un simulador que emula el proceso de cobro en las cajas de un supermercado, desarrollado en *Spring Boot* utilizando *Maven. Fue creado como parte de un caso de estudio planteado por la **IUDigital de Antioquia*.

## Características del Proyecto

- *Procesamiento Simulado:* Utiliza hilos para simular tiempos de procesamiento de productos.
- *Estructura Modular:* Separación en controladores, servicios y modelos.
- *Seguridad en el Desarrollo:* Validaciones, manejo de errores y configuración segura del sistema.

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- *Java 17* o superior.
- *Maven* para la gestión de dependencias y construcción del proyecto.
- *Git* para clonar el repositorio.

## Instalación y Ejecución

1. Clona el repositorio:

   bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
   cd tu-repositorio
   

2. Construye el proyecto usando Maven:

   bash
   mvn clean install
   

3. Inicia la aplicación:

   bash
   mvn spring-boot:run
   

4. La aplicación estará disponible en: http://localhost:8080.

## Uso del Sistema

El sistema expone un endpoint REST para procesar compras en el supermercado.

### Endpoint para Procesar Compras

- *URL:* /supermercado/procesarCompra
- *Método:* POST
- *Formato del JSON de Entrada:*

json
[
  {
    "cliente": "Cliente 1",
    "productos": [
      {
        "nombre": "Pan",
        "precio": 1.0,
        "tiempoProcesamiento": 1000
      }
    ]
  },
  {
    "cliente": "Cliente 2",
    "productos": [
      {
        "nombre": "Leche",
        "precio": 2.5,
        "tiempoProcesamiento": 1000
      },
      {
        "nombre": "Frijoles",
        "precio": 3.0,
        "tiempoProcesamiento": 1000
      }
    ]
  }
]


### Ejemplo de Solicitud con curl

bash
curl -X POST http://localhost:8080/supermercado/procesarCompra -H "Content-Type: application/json" -d '[
  {
    "cliente": "Cliente 1",
    "productos": [
      {
        "nombre": "Pan",
        "precio": 1.0,
        "tiempoProcesamiento": 1000
      }
    ]
  },
  {
    "cliente": "Cliente 2",
    "productos": [
      {
        "nombre": "Leche",
        "precio": 2.5,
        "tiempoProcesamiento": 1000
      },
      {
        "nombre": "Frijoles",
        "precio": 3.0,
        "tiempoProcesamiento": 1000
      }
    ]
  }
]'


## Funcionamiento del Sistema

1. *Controlador REST:* 
   - Recibe las solicitudes POST en el endpoint /supermercado/procesarCompra.
   - Valida los datos y los envía al servicio encargado.

2. *Servicio de Procesamiento:*
   - Simula el cobro de productos con tiempos específicos usando Thread.sleep().

3. *Consola del Servidor:*
   - Muestra el cliente atendido, detalles de los productos y tiempo total de procesamiento.

## Seguridad y Validaciones

- Validación de la estructura del JSON de entrada.
- Manejo de errores con respuestas claras en caso de datos incompletos o inválidos.
- Configuración segura del entorno para el despliegue.

## Autores

El proyecto fue desarrollado por *Tatiana* y *Santiago*, combinando habilidades en desarrollo backend y seguridad de software.
