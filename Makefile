all:
	mvn clean install

build-docker:
	docker build -t pma-postgres:latest -f postgres.docker .

run-postgres:
	docker run -d --name pma-db --rm -p 5432:5432 pma-postgres:latest