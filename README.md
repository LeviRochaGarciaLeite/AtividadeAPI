# AtividadeAPI

API REST com Spring Boot para cadastro e consulta de sensores.

## Entidade

Sensor:
- id: long
- unidade: String
- valor: float
- local: String

## Endpoints

- POST /sensores
- GET /sensores
- GET /sensores/{id}
- PUT /sensores/{id}
- DELETE /sensores/{id}
- GET /sensores/local/{local}

## Exemplo de JSON

```json
{
	"unidade": "celsius",
	"valor": 23.5,
	"local": "laboratorio"
}
```

## Como rodar

1. Ajuste o Java 17 no terminal:

```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH="$JAVA_HOME/bin:$PATH"
```

2. Execute a aplicacao:

```bash
mvn spring-boot:run
```

3. A API sobe em `http://localhost:8080`.

## Banco de dados

- H2 em memoria
- Console H2: `/h2-console`
- JDBC URL: `jdbc:h2:mem:sensoresdb`