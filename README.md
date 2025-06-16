<h1 align="center"> 💱 Conversor de Monedas - API </h1>

Un proyecto en Java que permite convertir entre diferentes monedas utilizando la API pública de [ExchangeRate-API](https://www.exchangerate-api.com/). Este conversor permite realizar conversiones personalizadas o rápidas entre monedas como USD, ARS, BRL y COP.

## 🚀 Funcionalidades

- Conversión de monedas en tiempo real utilizando una API externa.
- Soporte para múltiples monedas: dólar, peso argentino, real brasileño, peso colombiano, etc.
- Entrada interactiva desde consola.
- Lectura segura de API Key desde un archivo `.env`.
- Formateo claro del resultado de la conversión.

## 🧪 Ejemplo de uso
Bienvenido a tu Conversor de Monedas

1. Dólar => Peso argentino
2. Peso argentino => Dólar
__________________________

```
Ingrese su opción: 1
Ingrese el monto: 5
```
```
========== Conversión de Moneda ==========
Moneda de origen : USD
Moneda de destino : ARS
Tipo de cambio : 922.3500
Monto convertido : 4611.75 ARS
==========================================
```

## 🛠 Requisitos

- Java 17 o superior
- [Gson](https://github.com/google/gson) (para deserializar JSON)
- [dotenv-java](https://github.com/cdimascio/dotenv-java) (para cargar variables de entorno)
- IntelliJ IDEA o cualquier IDE compatible con Java

## 🧾 Instalación y uso

1. Clona el repositorio:

```bash
git clone https://github.com/laleska2506/conversor-de-monedas-api.git
cd conversor-de-monedas-api
```
2. Crea un archivo .env en la raíz del proyecto con tu clave de API:
```env
apiKey=TU_API_KEY_AQUI
```
3. Asegúrate de tener las dependencias (gson y dotenv-java) en tu carpeta lib/ o configuradas en tu IDE.

4. Ejecuta la clase Principal desde tu entorno de desarrollo o consola:

```
java Principal
```

## 📁 Estructura del Proyecto
```
conversor-de-monedas-api/
├── api/
│   └── Conexion.java
├── modelos/
│   ├── Moneda.java
│   └── MonedaRecord.java
├── .env
├── .gitignore
├── Principal.java
└── README.md
```
# Cambios Futuros

- Agregar interfaz gráfica (GUI)
- Guardar historial de conversiones
- Validar siglas de moneda en tiempo real
- Manejo de errores más detallado

# 📄 Licencia
Este proyecto está bajo la licencia MIT. Puedes usarlo, modificarlo y distribuirlo libremente

Creado con ❤️ por @laleska2506
