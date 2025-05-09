# marvel-challenge

## Descripción
Este proyecto es una aplicación desarrollada en Java que permite explorar información sobre personajes, cómics y eventos del universo Marvel utilizando la API oficial de Marvel. El objetivo es proporcionar una interfaz amigable para consultar y visualizar datos relacionados con este universo.

## Requisitos
- Java 11 o superior
- Maven 3.6 o superior
- Conexión a Internet (para consumir la API de Marvel)
- Clave pública y privada de la API de Marvel (puedes obtenerlas registrándote en [Marvel Developer Portal](https://developer.marvel.com/))

## Instalación
1. Clona este repositorio:
   ```bash
   git clone https://github.com/juanalsa/marvel-challenge.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd marvel-challenge
   ```
3. Configura las claves de la API de Marvel:
   - Crea un archivo `config.properties` en el directorio `src/main/resources`.
   - Agrega las siguientes líneas al archivo:
     ```
     marvel.api.publicKey=TU_CLAVE_PUBLICA
     marvel.api.privateKey=TU_CLAVE_PRIVADA
     ```
4. Compila el proyecto usando Maven:
   ```bash
   mvn clean install
   ```

## Uso
1. Ejecuta la aplicación:
   ```bash
   java -jar target/marvel-challenge.jar
   ```
2. Sigue las instrucciones en la interfaz para buscar personajes, cómics o eventos.

## Estructura del Proyecto
- `src/main/java`: Contiene el código fuente de la aplicación.
- `src/main/resources`: Archivos de configuración y recursos.
- `target`: Directorio donde se generan los archivos compilados.

## Contribuciones
Si deseas contribuir a este proyecto, por favor abre un issue o envía un pull request. ¡Toda ayuda es bienvenida!

## Licencia
Este proyecto está licenciado bajo la [MIT License](LICENSE).

## Créditos
- Datos proporcionados por la [API de Marvel](https://developer.marvel.com/).
