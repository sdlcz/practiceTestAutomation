# Selenium Java Framework (Dockerized)

This project can run Selenium tests locally or in Docker against a standalone Selenium Chrome container.

## Prerequisites

- Docker Desktop

## Run tests in Docker (recommended)

```bash
docker compose up --build --abort-on-container-exit
```

This starts:
- `selenium` (`selenium/standalone-chrome`)
- `tests` (Maven test runner in your project image)

## Run only the tests container (against existing Selenium URL)

```bash
docker build -t selenium-java-framework .
docker run --rm \
  -e SELENIUM_REMOTE_URL=http://host.docker.internal:4444/wd/hub \
  -e BROWSER=chrome \
  selenium-java-framework
```

## Local run (non-Docker)

If `SELENIUM_REMOTE_URL` is not set, the framework falls back to local driver creation from `config.properties`.
