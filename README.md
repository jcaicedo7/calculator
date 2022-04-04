# Proyecto calculator
API REST para realizar operaciones matemáticas, donde se obtiene un identificador para cada usuario, 
permite ir agregando los valores (operandos)  y finalmente realizar el cálculo matemático con los valores suministrados, 
de operaciones como: suma, resta, multiplicación, división y potenciación. 
Esta API REST desarrollada con Spring Boot y Redis como almacenamiento.

## Requisitos
Instalado y configurado las siguientes:
-JDK 11
-Maven versión 3.8.1
-Git 2.31.1
-Docker 20.10.13

## Empaquetar y despliegue
1. Descargar imagen redis:
docker pull redis

2. Desplegar redis:
docker run -d --name redis -p 6379:6379 redis
En caso de tener el puerto ocupado cambiarlo

3. Clonar el proyecto calculator :
git clone https://github.com/jcaicedo7/calculator.git
En caso de haber cambiado el puerto de redis modificar colocando el puerto e IP (si es necesario) en el siguiente el archivo
\calculator\src\main\resources\ application.properties

4. Instalar 
mvn install

5. Desplegar
mvn spring-boot:run

## Ejecución de Pruebas

| Metodo            | Recurso           | Descripcion                                                                                 |
|:------------------|:------------------|:----------------------------------------------------------------------------------------------|
| `POST`			| `/identify/create`		| Obtener identificador													|
| `POST`			| `/calculator/add`			| Agregar número (operando), ingresando valor				|
| `POST`			| `/calculator/calculate`	| Realizar el cálculo, ingresando nombre de la operación a realizar y booleano 													|
| `DELETE`			| `/calculator/clear`		| Eliminar todos los valores agregados	|
| `DELETE`			| `/calculator/remove`		| Eliminar un valor agregado, suministrando el valor	|
| `GET`				| `/calculator/query`		| Consulta los valores agregados al momento	|
| `DELETE`			| `/identify/delete`		| Elimina el identificador	|

Ejemplo Desarrollo de Pruebas Básicas

1. Obtener identificador
Método: POST
Ejecutar: http://localhost:8080/identify/create
Cuerpo: no aplica

Resultado: identificador, por ejemplo: 3e16f229-2456-4471-a9d6-be5754e1167b

2. Agregar un número (operando)
Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b
Método: POST
Ejecutar: http://localhost:8080/calculator/add
Cuerpo (formato json):
{
    "value": 2
}
Resultado: Numeros agreados 2.0

3. Agregar un segundo número (operando), porque se requiere mínimo 2 números para cualquier operación.
Método: POST
Ejecutar: http://localhost:8080/calculator/add
Cuerpo (formato json):
{
    "value": 3
}
Resultado: Numeros agreados 2.0, 3.0

4. Realizar cálculo de suma.
Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b
Método: POST
Ejecutar: http://localhost:8080/calculator/calculate
Cuerpo (formato json):
{
    "operation": "Addition",
    "addResult" : false
}
Resultado: 
{
    "values": "2.0,3.0",
    "operation": "Addition",
    "result": 5.0
}

Otras operaciones a realizar son:
Addition
Sustraction
Multiplication
Division
Exponential

En el parámetro “operation” debe ingresar exactamente el mismo nombre.
Con los números agregados, están disponibles para cualquier operación.

CASO 2
1. Consultar números agregados.
Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b
Método: GET
Ejecutar: http://localhost:8080/calculator/query
Resultado: 2.0,3.0

CASO 3
1. Eliminar un número
Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b
Método: DELETE
Ejecutar: http://localhost:8080/calculator/remove 
Cuerpo (formato json):
{
    "value":  2
}
Resultado: Actualizado 3.0

CASO 5
1. Eliminar todos números
Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b
Método: DELETE
Ejecutar: http://localhost:8080/calculator/clear
Resultado: Se eliminaron todos los datos agregados

CASO 6
1. Eliminar identificador suministrado
Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b
Método: DELETE
Ejecutar: http://localhost:8080/identify/delete
Resultado: Identificador eliminado





