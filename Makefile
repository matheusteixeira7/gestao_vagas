dev:
	mvn spring-boot:run

clean-install:
	mvn clean install

run-build:
	java -jar target/gestao_vagas-0.0.1.jar

run-clean-build:
	mvn clean install
	java -jar target/gestao_vagas-0.0.1.jar