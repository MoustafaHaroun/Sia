<div align="center">
  <img src="./sia-logo.svg" alt="Sia Logo" width="500" />

  <p><em>Market foresight — stock data, prediction & reporting API</em></p>

  <p>
    <img src="https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk" alt="Java 21" />
    <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=springboot" alt="Spring Boot" />
    <img src="https://img.shields.io/badge/status-in%20development-blue?style=flat-square" alt="Status" />
    <img src="https://img.shields.io/badge/license-MIT-lightgrey?style=flat-square" alt="License" />
  </p>
</div>

---

## Overview

**Sia** is a production-grade backend API built with Spring Boot, focused on stock market data aggregation, predictive analytics, and reporting. Named after the Egyptian god of perception and foresight, Sia is designed to watch the markets before they move.

This project serves as a showcase of real-world backend engineering — clean architecture, proper layering, and scalable design patterns.

---

## Features

- 📈 **Stock data ingestion** — fetch and store market data from external providers
- 🔍 **Analytics & reporting** — generate summaries and trend reports per symbol
- 🤖 **Prediction engine** — pluggable model layer for price forecasting
- 🔐 **Secure API** — JWT-based authentication and role-based access
- 📄 **REST API** — clean, versioned endpoints following REST conventions

---

<!-- ## Tech stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.x |
| Database | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| Auth | Spring Security + JWT |
| Build | Maven |
| Docs | Springdoc OpenAPI (Swagger UI) |

---

## Getting started

### Prerequisites

- Java 21+
- Maven 3.9+
- PostgreSQL 15+

### Run locally

```bash
# Clone the repository
git clone https://github.com/yourusername/sia.git
cd sia

# Configure environment
cp src/main/resources/application.example.yml src/main/resources/application-local.yml
# Edit application-local.yml with your DB credentials

# Build and run
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

The API will be available at `http://localhost:8080`.  
Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## Project structure

```
sia/
├── src/
│   ├── main/
│   │   ├── java/com/sia/
│   │   │   ├── config/          # Spring config, security, beans
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── service/         # Business logic
│   │   │   ├── repository/      # JPA repositories
│   │   │   ├── model/           # JPA entities
│   │   │   ├── dto/             # Request / response objects
│   │   │   └── exception/       # Global error handling
│   │   └── resources/
│   │       └── application.yml
│   └── test/                    # Unit & integration tests
└── pom.xml
```

--- -->

## Roadmap

- [ ] Market data ingestion (Alpha Vantage / Yahoo Finance)
<!-- - [ ] Symbol search & historical data endpoint
- [ ] Basic reporting (daily/weekly summaries)
- [ ] Prediction model integration
- [ ] Scheduled jobs for automated data sync
- [ ] Docker & docker-compose setup
- [ ] CI/CD pipeline (GitHub Actions) -->

---

## License

Apache — see [LICENSE](./LICENSE) for details.