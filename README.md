# Proyecto calculator
En el documento se registra la información técnica acerca de la API REST útil para realizar operaciones matemáticas, 
donde en la interacción parte de obtener un código para cada usuario, el cual le permite identificarlo para ir agregando los números 
(operandos)  y finalmente realizar el cálculo matemático con los valores suministrados. 
Las operaciones que permite realizar son: suma, resta, multiplicación, división y potenciación. 

## Requisitos
Instalado y configurado las siguientes:

-JDK 11

-Maven versión 3.8.1

-Git 2.31.1

-Docker 20.10.13


## Empaquetar y despliegue

A continuacion se presenta el paso a paso con los comandos.

1. Descargar imagen redis:

docker pull redis

2. Desplegar redis:

docker run -d --name redis -p 6379:6379 redis

NOTA: En caso de tener el puerto ocupado cambiarlo

3. Clonar el proyecto calculator :

git clone https://github.com/jcaicedo7/calculator.git

NOTA: En caso de haber cambiado el puerto de redis modificar colocando el puerto e IP (si es necesario) en el siguiente el archivo
\calculator\src\main\resources\ application.properties

4. Instalar:

mvn install

5. Desplegar
mvn spring-boot:run

## Recursos Dispuestos

| Metodo            | Recurso           | Descripcion                                                                                 |
|:------------------|:------------------|:----------------------------------------------------------------------------------------------|
| `POST`			| `/identify`				| Obtener identificador													|
| `POST`			| `/calculator/number`		| Agregar número (operando), ingresando valor				|
| `POST`			| `/calculator/operation`	| Realizar el cálculo, ingresando nombre de la operación a realizar y booleano 													|
| `DELETE`			| `/calculator/number`		| Eliminar todos los valores agregados	|
| `PUT`				| `/calculator/number`		| Actualizar valores agregados, suministrando el valor a eliminar	|
| `GET`				| `/calculator/number`		| Consulta los valores agregados al momento	|
| `DELETE`			| `/identify`				| Elimina el identificador	|

## Desarrollo de Pruebas Básicas

A continuación se presentan 5 casos de pruebas utilizando los recursos.

CASO PRUEBA 1:

1. Obtener identificador

Método: POST

Ejecutar: http://localhost:8080/identify

Cuerpo: no aplica

Resultado: identificador, por ejemplo: 3e16f229-2456-4471-a9d6-be5754e1167b

2. Agregar un número (operando)

Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b

Método: POST

Ejecutar: http://localhost:8080/calculator/number

Cuerpo (formato json):
{
    "value": 2
}

Resultado: Numeros agreados 2.0

3. Agregar un segundo número (operando), porque se requiere mínimo 2 números para cualquier operación.

Método: POST

Ejecutar: http://localhost:8080/calculator/number

Cuerpo (formato json):
{
    "value": 3
}

Resultado: Numeros agreados 2.0, 3.0

4. Realizar cálculo de suma.

Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b

Método: POST

Ejecutar: http://localhost:8080/calculator/operation

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

En el parámetro “operation” debe ingresar los anteriores nombres de forma exacta.
Con los números agregados, están disponibles para cualquier operación.

CASO PRUEBA 2

1. Consultar números agregados.

Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b

Método: GET

Ejecutar: http://localhost:8080/calculator/number

Resultado: 2.0,3.0

CASO PRUEBA 3

1. Eliminar un número

Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b

Método: PUT

Ejecutar: http://localhost:8080/calculator/number

Cuerpo (formato json):
{
    "value":  2
}

Resultado: Actualizado 3.0

CASO PRUEBA 4

1. Eliminar todos números

Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b

Método: DELETE

Ejecutar: http://localhost:8080/calculator/number

Resultado: Se eliminaron todos los datos agregados

CASO PRUEBA 5

1. Eliminar identificador suministrado

Agregar cabecera: Llave de nombre id y en el valor colocar el identificador suministrado: 3e16f229-2456-4471-a9d6-be5754e1167b

Método: DELETE

Ejecutar: http://localhost:8080/identify

Resultado: Identificador eliminado





